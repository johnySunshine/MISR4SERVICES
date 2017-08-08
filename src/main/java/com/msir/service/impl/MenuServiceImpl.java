package com.msir.service.impl;

import com.msir.dao.MenuDao;
import com.msir.pojo.MenuDO;
import com.msir.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fantasy on 2017/5/28.
 * menu 服务逻辑处理
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    public List<MenuDO> selectMenu() {
        return menuDao.listMenu();
    }

    public int saveMenu(MenuDO menuDO) {
        return menuDao.saveMenu(menuDO);
    }

    public int removeMenu(int id) {
        return menuDao.removeMenu(id);
    }

    public int updateMenu(MenuDO menuDO) {
        return menuDao.updateMenu(menuDO);
    }

    public MenuDO getMenu(int menuId) {
        return menuDao.getMenu(menuId);
    }
}
