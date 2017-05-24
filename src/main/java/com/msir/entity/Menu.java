package com.msir.entity;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/5.
 * menus对象
 */
public class Menu {
    private int id;
    private String menuText, menuUrl, target, subid, hubIsVisible;
    private List subMenu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuText() {
        return menuText;
    }

    public void setMenuText(String menuText) {
        this.menuText = menuText;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSubid() {
        return subid;
    }

    public void setSubid(String subid) {
        this.subid = subid;
    }

    public String getHubIsVisible() {
        return hubIsVisible;
    }

    public void setHubIsVisible(String hubIsVisible) {
        this.hubIsVisible = hubIsVisible;
    }

    public List getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List subMenu) {
        this.subMenu = subMenu;
    }
}
