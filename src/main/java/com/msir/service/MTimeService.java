package com.msir.service;

import com.msir.pojo.LocationDO;

import java.util.List;

public interface MTimeService {
    /**
     * 以下从时光网上面获取的资源信息
     */
    int saveLocation();

    int saveLocation(LocationDO locationDO);

    int updateLocation(LocationDO locationDO);

    int updateLocation();

    LocationDO getLocation(String cityName);

    List<LocationDO> listLocation();

    Object getMTimeShowTime(String locationId);

    Object getMTimeMovieComingNew(String locationId);

    Object getMTimeMovieDetail(String locationId, String movieId);

    Object getMTimeMovieCreditsWithTypes(String movieId);

    Object getMTimeVideo(String pageIndex, String movieId);

    Object getMTimeImageAll(String movieId);

}
