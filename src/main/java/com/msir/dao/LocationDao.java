package com.msir.dao;

import com.msir.pojo.LocationDO;

import java.util.List;

public interface LocationDao {
    int saveLocation(LocationDO locationDO);

    int updateLocation(LocationDO locationDO);

    LocationDO getLocation(String n);

    List<LocationDO> listLocation();
}
