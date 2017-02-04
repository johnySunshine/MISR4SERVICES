package com.soecode.osc.service.impl;

import com.soecode.osc.dao.CustomConfigDao;
import com.soecode.osc.entity.CustomConfig;
import com.soecode.osc.service.CustomConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/13.
 */
@Service
public class CusConfigServiceImpl implements CustomConfigService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CustomConfigDao customConfigDao;

    public List<CustomConfig> queryCustomConfig() {
        return customConfigDao.queryDao();
    }

    public int insertCustomConfig(CustomConfig customConfig) {
        return customConfigDao.insertDao(customConfig);
    }

    public int deleteCustomConfig(int menuId) {
        return customConfigDao.deleteDao(menuId);
    }

    public int updateCustomConfig(CustomConfig customConfig) {
        return customConfigDao.updateDao(customConfig);
    }
}
