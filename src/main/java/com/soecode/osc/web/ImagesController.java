package com.soecode.osc.web;

import com.soecode.osc.dto.AvatarInformation;
import com.soecode.osc.utils.GlobalUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

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
    public String insertImages(@Param("dataBase64") String dataBase64, @Param("ImagesName") String ImagesName, HttpServletRequest request) {
        BASE64Decoder decoder = new BASE64Decoder();
        String upLoadPath = request.getSession().getServletContext().getRealPath("");
        try {
            byte[] decodedBytes = decoder.decodeBuffer(dataBase64);
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
}
