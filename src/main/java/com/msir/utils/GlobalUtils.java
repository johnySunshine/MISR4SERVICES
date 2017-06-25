package com.msir.utils;

import com.auth0.jwt.internal.org.apache.commons.io.FileUtils;
import com.msir.enums.MenuStateEnum;
import com.msir.enums.UploadStateEnum;
import com.msir.web.FinalResult;
import org.apache.commons.fileupload.FileItem;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class GlobalUtils<T> {
    static final String DEFAULT_CHARSET = "UTF-8";
    static final int DEF_CONN_TIMEOUT = 30000;
    static final int DEF_READ_TIMEOUT = 30000;
    static final String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
    static Logger logger = LoggerFactory.getLogger(GlobalUtils.class);

    static String apiHost;
    static String pathName;
    static String apiKey;
    // 文件上传保存状态
    public static final String UPLOAD_FILE_PATH = "UPLOAD_ALL_IMAGES_FOLDER\\";

    public static final String UPLOAD_FILE_TEMP_PATH = "UPLOAD_TEMP_FOLDER\\";
    // 定义可以上传文件的后缀数组,默认"*"，代表所有
    public static final String[] FILE_POST_FIXS = {"*"};

    //图片类型
    static final String[] IMAGE_TYPES = {"gif", "jpeg", "png", "jpg", "tif", "bmp"};

    //其他文件上传的类型
    static final String[] OTHERS_FILE_TYPES = {"html", "htm", "doc", "xls", "txt", "zip", "rar", "pdf", "cll"};

    // 上传文件的最大长度
    static long maxFileSize = 1024 * 1024 * 1024 * 2L;// 2G
    // 一次读取多少字节
    static int bufferSize = 1024 * 8;

    /**
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return 网络请求字符串
     * @throws Exception
     */
    static String net(String strUrl, Map params, String method) {
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
    static String urlEncode(Map<String, Object> data) {
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
    static void upLoadFileInit() {
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
    static boolean mkDir(String filePath) {
        File file = new File(filePath);
        return !file.exists() && file.mkdirs();
    }

    /**
     * 替换文件路径中"\\"并且观察最后有没有'/'
     *
     * @param FilePath 文件目录位置
     * @return {String}
     */
    static String parsePath(String FilePath) {
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
     * @param fileName 文件名
     * @return String （有后缀名）
     */
    static String getFileTypeWithSuffix(String fileName) {
        if (fileName.lastIndexOf(".") != -1) {
            return fileName.substring(fileName.lastIndexOf("."));
        }
        return null;
    }

    /**
     * 获取文件的类型
     *
     * @param fileName 文件名字
     * @return String （没有后缀名）
     */
    static String getFileType(String fileName) {
        if (fileName.lastIndexOf(".") != -1) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return null;
    }

    /**
     * 传递一个文件名称和一个新名称，组合成一个新的带后缀文件名 当传递的文件名没有后缀，会添加默认的后缀
     *
     * @param fileName   文件名称
     * @param newName    新文件名称
     * @param nullSuffix 没有后缀的文件所添加的后缀;eg:txt
     * @return String:文件名称
     */
    static String getNewFileName(String fileName, String newName, String nullSuffix) {
        String suffix = getFileTypeWithSuffix(fileName);
        if (suffix != null) {
            newName += suffix;
        } else {
            newName = newName.concat(".").concat(nullSuffix);
        }
        return newName;
    }

    /**
     * 利用uuid产生一个随机的name
     *
     * @param fileName 带后缀的文件名称
     * @return String
     */
    static String getRandomName(String fileName, String fileType) {
        String randomName = UUID.randomUUID().toString();
        return getNewFileName(fileName, randomName, fileType);
    }

    /**
     * 用当前日期、时间和1000以内的随机数组合成的文件名称
     *
     * @param fileName 文件名称
     * @return 新文件名称
     */
    static String getNumberName(String fileName, String fileType) {
        SimpleDateFormat format = new SimpleDateFormat("yyMMddhhmmss");
        int rand = new Random().nextInt(1000);
        String numberName = format.format(new Date()) + rand;
        return getNewFileName(fileName, numberName, fileType);
    }

    /**
     * 返回可用的文件名
     *
     * @param fileName 文件名称
     * @param path     文件目录
     * @return 返回没有重复的名称
     */
    static String getBracketFileName(String fileName, String path) {
        return getBracketFileName(fileName, fileName, path, 1);
    }

    /**
     * 递归处理文件名称，直到名称不重复（对文件名、目录文件夹都可用） eg: a.txt --> a(1).txt
     * 文件夹upload--> 文件夹upload(1)
     *
     * @param fileName    文件名称
     * @param bracketName
     * @param path        文件路径
     * @param num         累加数字
     * @return 返回没有重复的名称
     */
    static String getBracketFileName(String fileName, String bracketName, String path, int num) {
        boolean exist = isFileExist(bracketName, path);
        if (exist) {
            int index = fileName.lastIndexOf(".");
            String suffix = "";
            bracketName = fileName;
            if (index != -1) {
                suffix = fileName.substring(index);
                bracketName = fileName.substring(0, index);
            }
            bracketName += "(" + num + ")" + suffix;
            num++;
            bracketName = getBracketFileName(fileName, bracketName, path, num);
        }
        return bracketName;
    }

    /**
     * 判断是否合法命名（不区分大小写）
     *
     * @param fileName   整个文件的名字
     * @param allowTypes 文件合法的类型
     * @return boolean
     */
    static boolean validTypeByName(String fileName, String[] allowTypes) {
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
    static boolean validTypeByName(String fileName, String[] allowTypes, boolean isNotIgnoreCase) {
        String fileSuffix = getFileType(fileName);
        return validTypeBySuffix(fileSuffix, allowTypes, isNotIgnoreCase);
    }

    /**
     * 根据文件后缀名判断是否合法（不区分大小写）
     *
     * @param fileSuffix 文件后缀名
     * @param allowTypes 文件合法的类型
     * @return boolean
     */
    static boolean validTypeBySuffix(String fileSuffix, String[] allowTypes) {
        return validTypeBySuffix(fileSuffix, allowTypes, true);
    }

    /**
     * 根据文件后缀名判断是否合法
     *
     * @param fileSuffix      文件后缀名
     * @param allowTypes      文件合法的类型
     * @param isNotIgnoreCase 是否区分大小写
     * @return boolean
     */
    static boolean validTypeBySuffix(String fileSuffix, String[] allowTypes, boolean isNotIgnoreCase) {
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
     * 验证是否为图片
     *
     * @param fileSuffix 文件后缀名
     * @return boolean
     */
    static boolean validTypeBySuffixForImages(String fileSuffix) {
        return validTypeBySuffix(fileSuffix, IMAGE_TYPES);
    }


    /**
     * 验证其他文件是否合法
     *
     * @param fileSuffix 文件后缀名
     * @return boolean
     */
    static boolean validTypeBySuffixForOtherFiles(String fileSuffix) {
        return validTypeBySuffix(fileSuffix, OTHERS_FILE_TYPES);
    }

    /**
     * 通过文件名验证是否是图片
     *
     * @param fileName 文件名
     * @return boolean
     */
    static boolean validTypeByNameForImages(String fileName) {
        return validTypeByName(fileName, IMAGE_TYPES);
    }

    /**
     * 通过文件名验证其他文件是否合法
     *
     * @param fileName 文件名
     * @return boolean
     */
    static boolean validTypeByNameForOtherFiles(String fileName) {
        return validTypeByName(fileName, OTHERS_FILE_TYPES);
    }


    /**
     * 删除文件
     *
     * @param file 文件
     * @return boolean
     */
    static boolean rmdir(File file) {
        boolean isDeleteStatus = false;
        if (file != null && file.exists()) {
            isDeleteStatus = file.delete();
        }
        return isDeleteStatus;
    }

    /**
     * 删除目录下文件
     *
     * @param filePath 文件目录下文件
     * @return boolean
     */
    public static boolean rmdir(String filePath) {
        return rmdir(new File(filePath));
    }

    /**
     * 删除指定目录下的文件
     *
     * @param fileName 文件名
     * @param filePath 文件路径
     * @return boolean
     */
    static boolean rmdir(String fileName, String filePath) {
        boolean isDeleteStatus = false;
        if (isFileExist(fileName, filePath)) {
            File file = new File(parsePath(filePath) + fileName);
            isDeleteStatus = file.delete();
        }
        return isDeleteStatus;
    }


    /**
     * 删除指定下所有文件
     *
     * @param file 文件
     * @return boolean
     */
    static boolean rmFileDir(File file) {
        boolean isDeleteStatus = false;
        if (file != null && file.exists() && file.isDirectory()) {
            File[] allFile = file.listFiles();
            for (File f : allFile) {
                isDeleteStatus = f.delete();
                if (!isDeleteStatus) {
                    logger.error("delete file" + f.getAbsolutePath() + "is error！");
                    break;
                }
            }
        }
        return isDeleteStatus;
    }

    /**
     * 删除指定目录所有文件，文件夹删除
     *
     * @param filePath 文件目录
     * @return boolean
     */
    static boolean rmFileDir(String filePath) {
        return rmFileDir(new File(filePath));
    }

    /**
     * 删除指定所有文件(包含子目录)
     *
     * @param file 文件
     * @return boolean
     */
    static boolean rmaFileDir(File file) {
        boolean isDeleteStatus = false;
        if (file != null && file.exists() && file.isDirectory()) {
            File[] allFiles = file.listFiles();
            for (File f : allFiles) {
                if (!f.isDirectory()) {
                    isDeleteStatus = f.delete();
                } else {
                    isDeleteStatus = rmaFileDir(f);
                }
                if (!isDeleteStatus) {
                    logger.error("delete file" + f.getAbsolutePath() + "is error！");
                    break;
                }
            }
        }
        return isDeleteStatus;
    }

    /**
     * 删除指定目录所有文件(包含子目录,文件夹不删除)
     *
     * @param filePath 文件路径
     * @return boolean
     */
    static boolean rmaFileDir(String filePath) {
        return rmaFileDir(new File(filePath));
    }

    /**
     * 判断该文件是否存在
     *
     * @param fileName 文件名称
     * @param filePath 目录
     * @return boolean
     */
    static boolean isFileExist(String fileName, String filePath) {
        File file = new File(parsePath(filePath) + fileName);
        return file.exists();
    }

    /**
     * 通过输入流参数上传文件
     *
     * @param fileName    文件名字
     * @param filePath    文件路径
     * @param inputStream 文件流
     * @return {UploadStateEnum}
     */
    static UploadStateEnum upLoadForStream(String fileName, String filePath, InputStream inputStream) {
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
    static UploadStateEnum upLoadForFile(String fileName, String filePath, File file) {
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
     *
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

    /**
     * 拷贝文件
     *
     * @param fileName 文件名字
     * @param filePath 文件路径
     * @param file     上传文件
     * @return boolean
     */
    static boolean uploadForCopyFile(String fileName, String filePath, File file) {
        upLoadFileInit();
        boolean uploadIsSuccess = false;
        if (file.length() <= maxFileSize) {
            filePath = parsePath(filePath);
            mkDir(filePath);
            File destFile = new File(filePath, fileName);
            try {
                FileUtils.copyFile(file, destFile);
                uploadIsSuccess = true;
            } catch (IOException e) {
                uploadIsSuccess = false;
                e.printStackTrace();
            }
        }
        return uploadIsSuccess;
    }

    /**
     * 拷贝指定类型的文件
     *
     * @param fileName   文件名字
     * @param filePath   文件路径
     * @param file       上传文件
     * @param allowTypes 合法类型
     * @return boolean
     */
    public static boolean uploadForCopyFile(String fileName, String filePath, File file, String[] allowTypes) {
        boolean uploadIsSuccess = false;
        if (validTypeByName(fileName, allowTypes)) {
            uploadIsSuccess = uploadForCopyFile(fileName, filePath, file);
        }
        return uploadIsSuccess;
    }

    /**
     * 获取上传文件名
     *
     * @param item 路径
     * @return String
     */
    public static String getUploadFileName(FileItem item) {
        // 获取路径名
        String value = item.getName();
        // 索引到最后一个反斜杠
        int start = value.lastIndexOf("/");
        // 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
        String filename = value.substring(start + 1);
        return filename;
    }

    /**
     * 获取上传的文件
     *
     * @param fileList 文件列表
     * @return FileItem
     */
    public static FileItem getUploadFileItem(List<FileItem> fileList) {
        for (FileItem fileItem : fileList) {
            if (!fileItem.isFormField()) {
                return fileItem;
            }
        }
        return null;
    }

    /**
     * 获取文件名字不包含后缀名
     *
     * @param fileName
     * @return
     */
    static String getUploadFileName(String fileName) {
        String[] fileNameList = fileName.split("\\.");
        for (String aFileNameList : fileNameList) {
            fileName = aFileNameList;
            break;
        }
        return fileName;
    }

    public static String httpsManager4get(URI apiUri) {
        HttpClientBuilder builder = HttpClients.custom();
        builder.setUserAgent(userAgent);
        final CloseableHttpClient httpclient = builder.build();
        CloseableHttpResponse response = null;
        HttpEntity entity;
        String responseStr = "";
        try {
            HttpGet httpget = new HttpGet(apiUri);
            response = httpclient.execute(httpget);
            entity = response.getEntity();
            responseStr = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseStr;
    }

    public static FinalResult authenErrorManager(HttpServletResponse resp) {
        FinalResult finalResult = null;
        if (resp.getStatus() == HttpServletResponse.SC_REQUEST_TIMEOUT) {
            return new FinalResult<String>(
                    true,
                    "",
                    "token已经过期",
                    "token",
                    "0");
        }
        if (resp.getStatus() == HttpServletResponse.SC_UNAUTHORIZED) {
            return new FinalResult<String>(
                    true,
                    "",
                    "没有权限",
                    "token",
                    "0");
        }
        return finalResult;
    }

    public static boolean authenErrorStatus(HttpServletResponse resp) {
        return resp.getStatus() == HttpServletResponse.SC_REQUEST_TIMEOUT || resp.getStatus() == HttpServletResponse.SC_UNAUTHORIZED;
    }
}
