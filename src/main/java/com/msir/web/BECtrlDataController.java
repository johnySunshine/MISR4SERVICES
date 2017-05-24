package com.msir.web;

import org.springframework.ui.Model;

/**
 * Created by Fantasy on 2017/1/8.
 * 增删该查的基本操作 父级
 */
public interface BECtrlDataController<T> {
    String addCtrl(T t, Model model);

    String delCtrl(String t, Model m);

    String updateCtrl(T t, Model model);

    String getCtrl(Model model);
}
