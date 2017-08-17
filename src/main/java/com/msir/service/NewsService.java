package com.msir.service;


/**
 * Created by Fantasy on 2017/8/3.
 * 关于新闻的接口
 */

public interface NewsService {
    Object getMoveList4One();
    Object getMoveDetail4One(String id);
    Object getMoveListHistory4One(String historyId);
    Object getTrailerList4EyePetizer();
}
