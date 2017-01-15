package com.soecode.lyf.dao;

import com.soecode.lyf.entity.Menu;
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
