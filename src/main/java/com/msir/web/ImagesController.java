package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.msir.dto.AvatarBasePath;
import com.msir.dto.AvatarInformation;
import com.msir.entity.Images;
import com.msir.service.ImageService;
import com.msir.utils.GlobalUtils;
import com.msir.utils.ImagesUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by Fantasy on 2017/2/12.
 * 图片的view 层级
 */
@Controller
@RequestMapping("/Images")
public class ImagesController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "toAddImgSide", method = RequestMethod.GET)
    public String forwardImagesAdd() {
        return "template/poster/addPoster";
    }

    /**
     * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
     * 格式的 然后再将其真正写到 对应目录的硬盘上
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ImagesUpload", method = RequestMethod.POST)
    public JSONObject fileImagesUpload(HttpServletRequest request, HttpServletResponse response) {

        AvatarBasePath avatarBasePath = new AvatarBasePath();


        String basePath = request.getSession().getServletContext().getRealPath("");

        //创建保存文件
        String IMAGES_SAVE_FOLDER = basePath + GlobalUtils.UPLOAD_FILE_PATH;
        //创建缓存文件
        String IMAGES_TEMPLE_FOLDER = basePath + GlobalUtils.UPLOAD_FILE_TEMP_PATH;

        this.makeDir(IMAGES_TEMPLE_FOLDER);

        this.makeDir(IMAGES_SAVE_FOLDER);

        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            // 获得磁盘文件条目工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();

            /*
            如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
             设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
            */
            factory.setRepository(new File(IMAGES_TEMPLE_FOLDER));
            // 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
            factory.setSizeThreshold(1024 * 1024);

            // 高水平的API文件上传处理
            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

            /*提交上来的信息都在这个list里面
            这意味着可以上传多个文件
            请自行组织代码*/

            List<FileItem> fileItemsList = servletFileUpload.parseRequest(request);
            // 获取上传的文件
            AvatarInformation avatarInfo = this.getUploadOtherField(fileItemsList);

            FileItem item = GlobalUtils.getUploadFileItem(fileItemsList);

            // 获取文件名
            String filename = GlobalUtils.getUploadFileName(item);
            //  获取文件名
            String fileNameNowSuffix = GlobalUtils.getUploadFileName(filename);

            String newFileName = GlobalUtils.getNumberName(fileNameNowSuffix, GlobalUtils.getFileType(filename));

            // 真正写到磁盘上
            assert item != null;
            if (this.isCutImages(avatarInfo, item, IMAGES_SAVE_FOLDER, newFileName)) {
                avatarBasePath.setAvatarName(newFileName);
                avatarBasePath.setAvatarFilePath(GlobalUtils.UPLOAD_FILE_PATH + '\\' + avatarInfo.getAvatarSrc());
            } else {
                item.write(new File(IMAGES_TEMPLE_FOLDER, newFileName));
                avatarBasePath.setAvatarName(newFileName);
                avatarBasePath.setAvatarFilePath(GlobalUtils.UPLOAD_FILE_TEMP_PATH);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (JSONObject) JSON.toJSON(avatarBasePath);
    }

    @ResponseBody
    @RequestMapping(value = "submitImages", method = RequestMethod.POST, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String submitAvatar(String imagesList) {
        List<Images> ImagesList = JSON.parseArray(imagesList, Images.class);
        for (Images i : ImagesList) {
            imageService.insertDao(i);
        }
        return forwardImagesAdd();
    }


    /**
     * 创建文件
     *
     * @param filePath 文件目录
     */
    public void makeDir(String filePath) {
        if (GlobalUtils.mkDir(filePath)) {
            GlobalUtils.mkDir(filePath);
        }
    }


    private boolean isCutImages(AvatarInformation avatarInfo, FileItem fileItem, String filePath, String fileNewName) {
        if (avatarInfo.isAvatarIsCut()) {
            try {
                String avatarType = avatarInfo.getAvatarSrc();
                filePath = filePath + '\\' + avatarType;
                this.makeDir(filePath);
                int offsetX = Integer.parseInt(avatarInfo.getOffsetX());
                int offsetY = Integer.parseInt(avatarInfo.getOffsetY());
                int avatarWidth = Integer.parseInt(avatarInfo.getAvatarWidth());
                int avatarHeight = Integer.parseInt(avatarInfo.getAvatarHeight());
                ImagesUtils.imagesCutByStream(fileItem.getInputStream(), new File(filePath, fileNewName), offsetX, offsetY, avatarWidth, avatarHeight);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }


    private AvatarInformation getUploadOtherField(List<FileItem> fileList) {
        AvatarInformation avatarInformation = new AvatarInformation();
        for (FileItem fileItem : fileList) {
            if (!fileItem.isFormField()) {
                continue;
            }
            if (fileItem.getFieldName().equals("avatarSrc")) {
                avatarInformation.setAvatarSrc(fileItem.getString());
            }
            if (fileItem.getFieldName().equals("avatarOption")) {
                avatarInformation.setAvatarOption(fileItem.getString());
            }
            if (fileItem.getFieldName().equals("avatarFile")) {
                avatarInformation.setAvatarFile(fileItem.getString());
            }
            if (fileItem.getFieldName().equals("offsetX")) {
                avatarInformation.setOffsetX(fileItem.getString());
            }
            if (fileItem.getFieldName().equals("offsetY")) {
                avatarInformation.setOffsetY(fileItem.getString());
            }
            if (fileItem.getFieldName().equals("avatarWidth")) {
                avatarInformation.setAvatarWidth(fileItem.getString());
            }
            if (fileItem.getFieldName().equals("avatarHeight")) {
                avatarInformation.setAvatarHeight(fileItem.getString());
            }
            if (fileItem.getFieldName().equals("avatarIsCut")) {
                avatarInformation.setAvatarIsCut(fileItem.getString().equals("true"));

            }
        }
        return avatarInformation;
    }


}
