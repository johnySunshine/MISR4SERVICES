package com.soecode.osc.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.soecode.osc.dto.AvatarBasePath;
import com.soecode.osc.utils.GlobalUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by Fantasy on 2017/2/12.
 * 图片的view 层级
 */
@Controller
@RequestMapping("/Images")
public class ImagesController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "toAddImgSide", method = RequestMethod.GET)
    public String forwardImagesAdd() {
        return "template/poster/addPoster";
    }

    @ResponseBody
    @RequestMapping(value = "insertImages", method = RequestMethod.POST, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String insertImages(@RequestParam String dataBase64, @RequestParam String ImagesName, HttpServletRequest request) {
        String upLoadPath = request.getSession().getServletContext().getRealPath("");
        try {
            byte[] decodedBytes = Base64Utils.decodeFromString(dataBase64);
            String newPosterName = UUID.randomUUID().toString() + ".png";
            String upLoadPathPoster = upLoadPath + "IMAGES\\";
            System.out.println(upLoadPathPoster);
            if (GlobalUtils.mkDir(upLoadPathPoster)) {
                GlobalUtils.mkDir(upLoadPathPoster);
            }
            FileOutputStream outPoster = new FileOutputStream(upLoadPathPoster + "/" + newPosterName);
            outPoster.write(decodedBytes);
            outPoster.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }


    @ResponseBody
    @RequestMapping(value = "upLoadImages", method = RequestMethod.POST, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String upLoadImages(MultipartFile[] multipartFile) {
        System.out.println(multipartFile);
        return "success";
    }

    /**
     * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
     * 格式的 然后再将其真正写到 对应目录的硬盘上
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "ImagesUpload", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject fileImagesUpload(HttpServletRequest request, HttpServletResponse response) {
        // 存放临时文件的目录
        String TEMP_FOLDER = "/";
        // 存放临时文件的目录,存放xxx.tmp文件的目录
        String basePath = request.getSession().getServletContext().getRealPath("");
        String IMAGES_SAVE_FOLDER = basePath + GlobalUtils.UPLOAD_FILE_PATH;
        if (GlobalUtils.mkDir(basePath + GlobalUtils.UPLOAD_FILE_TEMP_PATH)) {
            GlobalUtils.mkDir(basePath + GlobalUtils.UPLOAD_FILE_TEMP_PATH);
        }
        if (GlobalUtils.mkDir(IMAGES_SAVE_FOLDER)) {
            GlobalUtils.mkDir(IMAGES_SAVE_FOLDER);
        }
        AvatarBasePath avatarBasePath = new AvatarBasePath();
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            // 获得磁盘文件条目工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
            // 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
            factory.setRepository(new File(TEMP_FOLDER));
            // 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
            factory.setSizeThreshold(1024 * 1024);

            // 高水平的API文件上传处理
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 提交上来的信息都在这个list里面
            // 这意味着可以上传多个文件
            // 请自行组织代码
            List<FileItem> list = upload.parseRequest(request);
            // 获取上传的文件
            FileItem item = GlobalUtils.getUploadFileItem(list);
            // 获取文件名
            String filename = GlobalUtils.getUploadFileName(item);
            // 保存后的文件名
            String fileNameNowSuffix = GlobalUtils.getUploadFileName(filename);
            String newFileName = GlobalUtils.getRandomName(fileNameNowSuffix, GlobalUtils.getFileType(filename));
            // 真正写到磁盘上
            assert item != null;
            item.write(new File(IMAGES_SAVE_FOLDER, newFileName)); // 第三方提供的
            avatarBasePath.setAvatarName(newFileName);
            avatarBasePath.setAvatarFilePath(GlobalUtils.UPLOAD_FILE_PATH);
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (JSONObject) JSON.toJSON(avatarBasePath);
    }

}
