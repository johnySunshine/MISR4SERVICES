package com.msir.pojo;

import java.util.Date;
import java.util.List;

/**
 * Created by Fantasy on 2017/5/26.
 */
public class MenuDO {
    private int id;
    private Date gmtCreate;
    private Date gmtModified;
    private String menuTitle;
    private String menuUrl;
    private String menuTarget;
    private int menuSubId;
    private boolean menuVisible;
    private List<MenuDO> subMenuList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuTarget() {
        return menuTarget;
    }

    public void setMenuTarget(String menuTarget) {
        this.menuTarget = menuTarget;
    }

    public int getMenuSubId() {
        return menuSubId;
    }

    public void setMenuSubId(int menuSubId) {
        this.menuSubId = menuSubId;
    }


    public List<MenuDO> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<MenuDO> subMenuList) {
        this.subMenuList = subMenuList;
    }

    public boolean isMenuVisible() {
        return menuVisible;
    }

    public void setMenuVisible(boolean menuVisible) {
        this.menuVisible = menuVisible;
    }
}
