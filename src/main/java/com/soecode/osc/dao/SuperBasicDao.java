package com.soecode.osc.dao;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/12.
 */
public interface SuperBasicDao<T> {
    List<T> queryDao();

    int insertDao(T t);

    int deleteDao(int t);

    int updateDao(T t);
}
