package com.msir.dao;

import com.msir.pojo.ConfigDO;

import java.util.List;

/**
 * Created by Fantasy on 2017/6/25.
 *
 */
public interface CustomConfigDao {
    List<ConfigDO> listConfig();

    int saveConfig(ConfigDO configDO);

    int removeConfig(int id);

    int updateConfig(ConfigDO configDO);

    ConfigDO getConfig(int id);
}
