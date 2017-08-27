package com.msir.dao;

import com.msir.pojo.ConfigDO;
import com.msir.provider.CustomConfigProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by wengzequn on 2017/6/25.
 */
public interface CustomConfigDao {
    List<ConfigDO> listConfig();

    int saveConfig(ConfigDO configDO);

    int removeConfig(int id);

    int updateConfig(ConfigDO configDO);

    ConfigDO getConfig(int id);

    @SelectProvider(type = CustomConfigProvider.class, method = "listValueByKey")
    List<String> getConfigByKey(@Param("configKey") String configKey);
}
