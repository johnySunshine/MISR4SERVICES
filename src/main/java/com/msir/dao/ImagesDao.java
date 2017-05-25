package com.msir.dao;

import com.msir.pojo.Images;


/**
 * Created by Fantasy on 2017/2/24.
 */
public interface ImagesDao extends SuperBasicDao<Images> {

    int insertDao(Images images);

}

