package com.soecode.osc.utils;

import com.soecode.osc.enums.UploadStateEnum;
import org.springframework.ui.Model;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public abstract class GlobalUtils<T> {
    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static final String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";


    // 文件上传保存状态
    public static final String UPLOAD_FILE_PATH = "/upload/";

    // 定义可以上传文件的后缀数组,默认"*"，代表所有
    public static final String[] FILE_POST_FIXS = {"*"};

    //图片类型
    public static final String[] IMAGE_TYPES = {"gif", "jpeg", "png", "jpg", "tif", "bmp"};

    //其他文件上传的类型
    public static final String[] OTHERS_FILE_TYPES = {"html", "htm", "doc", "xls", "txt", "zip", "rar", "pdf", "cll"};

    // 上传文件的最大长度
    public static long maxFileSize = 1024 * 1024 * 1024 * 2L;// 2G
    // 一次读取多少字节
    public static int bufferSize = 1024 * 8;

    /**
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return 网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params, String method) {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if (method == null || method.equals("GET")) {
                strUrl = strUrl + "?" + urlEncode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if (method == null || method.equals("GET")) {
                conn.setRequestMethod("GET");
            } else {
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params != null && (method != null && method.equals("POST"))) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlEncode(params));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEFAULT_CHARSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    public static String urlEncode(Map<String, Object> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 将返回的结果进行打印
     *
     * @param url        请求地址
     * @param params     请求参数
     * @param methodType 请求方法
     * @return {String}
     */
    public static String resultThrowException(String url, Map params, String methodType) {
        String result = "";
        try {
            result = GlobalUtils.net(url, params, methodType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 操作返回的信息
     *
     * @param model
     * @param messages
     */
    public static void addMessages(Model model, String messages) {
        model.addAttribute("code_msg", messages);
    }


    /**
     * 上传文件初始化
     */
    public static void upLoadFileInit() {
        if (bufferSize > Integer.MAX_VALUE) {
            bufferSize = 1024 * 8;
        } else if (bufferSize < 8) {
            bufferSize = 8;
        }
        if (maxFileSize < 1) {
            maxFileSize = 1024 * 1024 * 1024 * 2L;
        } else if (maxFileSize > Long.MAX_VALUE) {
            maxFileSize = 1024 * 1024 * 1024 * 2L;
        }
    }

    /**
     * 创建指定的filePath路径目录(创建文件夹)
     *
     * @param filePath 文件目录位置
     * @return {boolean}
     * @throws Exception
     */
    public static boolean mkDir(String filePath) {
        File file = new File(filePath);
        return !file.exists() && file.mkdirs();
    }

    /**
     * 替换文件路径中"\\"并且观察最后有没有'/'
     *
     * @param FilePath 文件目录位置
     * @return {String}
     */
    public static String parsePath(String FilePath) {
        FilePath = FilePath.replace("\\", "/");
        String lastChar = FilePath.substring(FilePath.length() - 1);
        if (!"/".equals(lastChar)) {
            FilePath += "/";
        }
        return FilePath;
    }

    /**
     * 获取文件的类型
     *
     * @param fileName 文件名字
     * @return String
     */
    public static String getFileType(String fileName) {
        if (fileName.lastIndexOf(".") != -1) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return null;
    }

    /**
     * 判断是否合法命名
     *
     * @param fileName   整个文件的名字
     * @param allowTypes 文件合法的类型
     * @return boolean
     */
    public static boolean validTypeByName(String fileName, String[] allowTypes) {
        return validTypeByName(fileName, allowTypes, true);
    }

    /**
     * 判断是否合法命名重写了validTypeByName
     *
     * @param fileName        整个文件的名字
     * @param allowTypes      文件合法的类型
     * @param isNotIgnoreCase 是否区分大小写
     * @return boolean
     */
    public static boolean validTypeByName(String fileName, String[] allowTypes, boolean isNotIgnoreCase) {
        String fileSuffix = getFileType(fileName);
        boolean fileIsAllow = false;
        if (allowTypes.length > 0 && "*".equals(allowTypes[0])) {
            fileIsAllow = true;
        } else {
            for (String allow : allowTypes) {
                if (isNotIgnoreCase) {
                    if (fileSuffix != null && fileSuffix.equalsIgnoreCase(allow)) {
                        fileIsAllow = true;
                        break;
                    }
                } else {
                    if (fileSuffix != null && fileSuffix.equals(allow)) {
                        fileIsAllow = true;
                        break;
                    }
                }
            }
        }
        return fileIsAllow;
    }


    /**
     * 通过输入流参数上传文件
     *
     * @param fileName    文件名字
     * @param filePath    文件路径
     * @param inputStream 文件流
     * @return {UploadStateEnum}
     */
    public static UploadStateEnum upLoadForStream(String fileName, String filePath, InputStream inputStream) {
        upLoadFileInit();
        UploadStateEnum uploadStateEnum = UploadStateEnum.UPLOAD_FAILURE;
        FileOutputStream fileOutputStream = null;
        try {
            filePath = parsePath(filePath);
            mkDir(filePath);
            fileOutputStream = new FileOutputStream(filePath + fileName);
            byte[] everyReadSize = new byte[bufferSize];
            int intLength = 0;
            while ((intLength = inputStream.read(everyReadSize)) > 0) {
                fileOutputStream.write(everyReadSize, 0, intLength);
            }
            uploadStateEnum = uploadStateEnum.UPLOAD_SUCCESS;
        } catch (FileNotFoundException e) {
            uploadStateEnum = uploadStateEnum.UPLOAD_NOT_FOUND;
            e.printStackTrace();
        } catch (IOException e) {
            uploadStateEnum = uploadStateEnum.UPLOAD_FAILURE;
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return uploadStateEnum;
    }

    /**
     * 通过文件来进行上传
     *
     * @param fileName 文件名
     * @param filePath 文件路径
     * @param file     上传的文件
     * @return UploadStateEnum
     */
    public static UploadStateEnum upLoadForFile(String fileName, String filePath, File file) {
        upLoadFileInit();
        UploadStateEnum uploadStateEnum = UploadStateEnum.UPLOAD_FAILURE;
        FileInputStream fileInputStream = null;
        long fileSize = file.length();
        if (fileSize < 0) {
            uploadStateEnum = UploadStateEnum.UPLOAD_ZERO_SIZE;
        } else {
            if (fileSize < maxFileSize) {
                try {
                    fileInputStream = new FileInputStream(file);
                    uploadStateEnum = upLoadForStream(fileName, filePath, fileInputStream);
                } catch (FileNotFoundException e) {
                    uploadStateEnum = UploadStateEnum.UPLOAD_NOT_FOUND;
                    e.printStackTrace();
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                uploadStateEnum = UploadStateEnum.UPLOAD_OVER_SIZE;
            }
        }
        return uploadStateEnum;
    }

    /**
     * 上传文件验证是否合法（上传指定文件类型）
     * @param fileName   文件名字
     * @param filePath   文件路径
     * @param file       上传文件
     * @param allowTypes 文件是否合法的数组
     * @return UploadStateEnum
     */
    public static UploadStateEnum uploadFileWithValidType(String fileName, String filePath, File file, String[] allowTypes) {
        UploadStateEnum uploadStateEnum = UploadStateEnum.UPLOAD_FAILURE;
        if (validTypeByName(fileName, allowTypes)) {
            uploadStateEnum = upLoadForFile(fileName, filePath, file);
        } else {
            uploadStateEnum = uploadStateEnum.UPLOAD_TYPE_ERROR;
        }
        return uploadStateEnum;
    }






}
