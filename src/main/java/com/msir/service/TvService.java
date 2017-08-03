package com.msir.service;

/**
 * Created by Fantasy on 2017/8/3.
 *
 */
public interface TvService {
    Object getCategory();

    Object getChannel(String pId);

    Object getProgram(String channelCode, String date);

    Object getHubHot();
}
