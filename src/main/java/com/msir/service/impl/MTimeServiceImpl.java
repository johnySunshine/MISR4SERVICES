package com.msir.service.impl;

import com.msir.dao.LocationDao;
import com.msir.pojo.LocationDO;
import com.msir.service.MTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Fantasy on 2017/8/7.
 */
@Service
public class MTimeServiceImpl implements MTimeService {
    @Autowired
    private LocationDao locationDao;

    public int saveLocation(LocationDO locationDO) {
        return locationDao.saveLocation(locationDO);
    }

    public Object getMTimeShowTime(int locationId) {
        return null;
    }

    public Object getMTimeMovieComingNew(int locationId) {
        return null;
    }

    public Object getMTimeMovieDetail(int locationId, String movieId) {
        return null;
    }

    public Object getMTimeMovieCreditsWithTypes(int movieId) {
        return null;
    }

    public Object getMTimeVideo(int pageIndex, int movieId) {
        return null;
    }

    public Object getMTimeImageAll(int movieId) {
        return null;
    }
}
