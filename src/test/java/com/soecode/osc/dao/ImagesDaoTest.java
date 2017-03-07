package com.soecode.osc.dao;

import com.soecode.osc.BaseTest;
import com.soecode.osc.entity.Images;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Fantasy on 2017/2/24.
 */
public class ImagesDaoTest extends BaseTest {
    @Autowired
    private ImagesDao imagesDao;

    @Test
    public void TestImagesDao(){
        Images images = new Images();
        images.setHref("test");
        images.setImageType("16x9");
        images.setMovieId("123456");
        imagesDao.insertDao(images);
    }
}
