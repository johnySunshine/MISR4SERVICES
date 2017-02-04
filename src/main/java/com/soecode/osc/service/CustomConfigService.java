package com.soecode.osc.service;

import com.soecode.osc.entity.CustomConfig;

import java.util.List;

public interface CustomConfigService {
    List<CustomConfig> queryCustomConfig();

    int insertCustomConfig(CustomConfig customConfig);

    int deleteCustomConfig(int menuId);

    int updateCustomConfig(CustomConfig customConfig);
}
