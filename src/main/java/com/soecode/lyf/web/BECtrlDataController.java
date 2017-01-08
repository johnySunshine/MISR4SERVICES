package com.soecode.lyf.web;

import org.springframework.ui.Model;

/**
 * Created by Fantasy on 2017/1/8.
 * 增删该查的基本操作 父级
 */
public class BECtrlDataController<T> {
    public String addCtrl(T t, Model model) {
        return "addCtrl";
    }

    public String delCtrl() {
        return "delCtrl";
    }

    public String updateCtrl() {
        return "updateCtrl";
    }

    public String getCtrl(Model model) {
        return "getCtrl";
    }
}
