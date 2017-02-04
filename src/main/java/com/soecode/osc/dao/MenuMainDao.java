package com.soecode.osc.dao;

import com.soecode.osc.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/5.
 *  菜单接口
 */
public interface MenuMainDao extends SuperBasicDao<Menu>{
    List<Menu> queryDao();

    int insertDao(Menu menu);

    int deleteDao(@Param("menuId") int menuId);

    int updateDao(Menu menu);
}
