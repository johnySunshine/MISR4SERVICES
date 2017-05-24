package com.msir.service.impl;

import com.msir.dao.ImagesDao;
import com.msir.entity.Images;
import com.msir.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Fantasy on 2017/2/24.
 *
 */
@Service
public class ImageServiceImpl implements ImageService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ImagesDao imagesDao;

    public int insertDao(Images images) {
        return imagesDao.insertDao(images);
    }
}
