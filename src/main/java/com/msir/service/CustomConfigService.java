package com.msir.service;

import com.msir.pojo.ConfigDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Fantasy on 2017/6/25.
 */
public interface CustomConfigService {
    List<ConfigDO> listConfig();

    int saveConfig(ConfigDO configDO);

    int removeConfig(int id);

    int updateConfig(ConfigDO configDO);

    ConfigDO getConfig(int id);

    List<ConfigDO> getConfigByKey(@Param("configKey") String configKey);
}
