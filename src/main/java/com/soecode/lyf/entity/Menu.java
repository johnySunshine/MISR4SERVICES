package com.soecode.lyf.entity;

/**
 * Created by Fantasy on 2017/1/5.
 */
public class Menu {
    private int id;
    private String menuText, menuUrl, target, subid, iconsUrl;

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

    public String getIconsUrl() {
        return iconsUrl;
    }

    public void setIconsUrl(String iconsUrl) {
        this.iconsUrl = iconsUrl;
    }
}
