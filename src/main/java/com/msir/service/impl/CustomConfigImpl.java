package com.msir.service.impl;

import com.msir.dao.CustomConfigDao;
import com.msir.pojo.ConfigDO;
import com.msir.service.CustomConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fantasy on 2017/6/25.
 */
@Service
public class CustomConfigImpl implements CustomConfigService {
    @Autowired
    private CustomConfigDao customConfigDao;

    public List<ConfigDO> listConfig() {
        return customConfigDao.listConfig();
    }

    public int saveConfig(ConfigDO configDO) {
        return customConfigDao.saveConfig(configDO);
    }

    public int removeConfig(int id) {
        return customConfigDao.removeConfig(id);
    }

    public int updateConfig(ConfigDO configDO) {
        return customConfigDao.updateConfig(configDO);
    }

    public ConfigDO getConfig(int id) {
        return customConfigDao.getConfig(id);
    }
}
