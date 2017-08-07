package com.msir.service.impl;

import com.alibaba.fastjson.JSON;
import com.msir.dao.LocationDao;
import com.msir.dto.LocationDTO;
import com.msir.pojo.LocationDO;
import com.msir.service.MTimeService;
import com.msir.utils.GlobalUtils;
import com.msir.utils.HttpUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fantasy on 2017/8/7.
 */
@Service
public class MTimeServiceImpl implements MTimeService {
    @Autowired
    private LocationDao locationDao;

    public int saveLocation() {
        int status = 0;
        this.initHttps();
        HttpUtils.setPathName("/Showtime/HotCitiesByCinema.api");
        URI uri = HttpUtils.converseURI();
        LocationDTO locationDTOs = JSON.parseObject(GlobalUtils.httpsManager4get(uri), LocationDTO.class);
        List<LocationDO> LocationDOs = locationDTOs.getP();
        for (LocationDO lo : LocationDOs) {
            status = this.saveLocation(lo);
        }
        return status;
    }

    public int saveLocation(LocationDO locationDO) {
        return locationDao.saveLocation(locationDO);
    }

    public int updateLocation() {
        int status = 0;
        this.initHttps();
        HttpUtils.setPathName("/Showtime/HotCitiesByCinema.api");
        URI uri = HttpUtils.converseURI();
        LocationDTO locationDTOs = JSON.parseObject(GlobalUtils.httpsManager4get(uri), LocationDTO.class);
        List<LocationDO> LocationDOs = locationDTOs.getP();
        for (LocationDO lo : LocationDOs) {
            status = this.updateLocation(lo);
        }
        return status;
    }

    public int updateLocation(LocationDO locationDO) {
        return locationDao.updateLocation(locationDO);
    }

    public LocationDO getLocation(String cityName) {
        return locationDao.getLocation(cityName);
    }

    public List<LocationDO> listLocation() {
        return locationDao.listLocation();
    }

    public Object getMTimeShowTime(String locationId) {
        this.initHttps();
        HttpUtils.setPathName("/Showtime/LocationMovies.api");
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        postParameters.add(new BasicNameValuePair("locationId", locationId));
        URI uri = HttpUtils.converseURI(postParameters);
        return GlobalUtils.httpsManager4get(uri);
    }

    public Object getMTimeMovieComingNew(String locationId) {
        this.initHttps();
        HttpUtils.setPathName("/Movie/MovieComingNew.api");
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        postParameters.add(new BasicNameValuePair("locationId", locationId));
        URI uri = HttpUtils.converseURI(postParameters);
        return GlobalUtils.httpsManager4get(uri);
    }

    public Object getMTimeMovieDetail(String locationId, String movieId) {
        this.initHttps();
        HttpUtils.setPathName("/movie/detail.api");
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        postParameters.add(new BasicNameValuePair("locationId", locationId));
        postParameters.add(new BasicNameValuePair("movieId", movieId));
        URI uri = HttpUtils.converseURI(postParameters);
        return GlobalUtils.httpsManager4get(uri);
    }

    public Object getMTimeMovieCreditsWithTypes(String movieId) {
        this.initHttps();
        HttpUtils.setPathName("/Movie/MovieCreditsWithTypes.api");
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        postParameters.add(new BasicNameValuePair("locationId", movieId));
        URI uri = HttpUtils.converseURI(postParameters);
        return GlobalUtils.httpsManager4get(uri);
    }

    public Object getMTimeVideo(String pageIndex, String movieId) {
        this.initHttps();
        HttpUtils.setPathName("/Movie/Video.api");
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        postParameters.add(new BasicNameValuePair("pageIndex", pageIndex));
        postParameters.add(new BasicNameValuePair("movieId", movieId));
        URI uri = HttpUtils.converseURI(postParameters);
        return GlobalUtils.httpsManager4get(uri);
    }

    public Object getMTimeImageAll(String movieId) {
        this.initHttps();
        HttpUtils.setPathName("/Movie/ImageAll.api");
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        postParameters.add(new BasicNameValuePair("movieId", movieId));
        URI uri = HttpUtils.converseURI(postParameters);
        return GlobalUtils.httpsManager4get(uri);
    }

    private void initHttps() {
        HttpUtils.setSchemeName("https");
        HttpUtils.setHostName("api-m.mtime.cn");
        HttpUtils.setPort(0);
    }

}
