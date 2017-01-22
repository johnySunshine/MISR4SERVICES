package com.soecode.lyf.entity;

/**
 * Created by Fantasy on 2017/1/22.
 * 电影实体类
 * <p/>
 * contentInformation:{
 * castAndCrew,//list,
 * title,影片标题
 * originalTitle,影片原标题
 * longDescription,描述
 * childProtectionId，儿童保护ID
 * childProtectionLevel，儿童保护等级，
 * genres,类别
 * mainGenre，主类别
 * }
 */
public class Movie {
    private int id;
    private String
            title,
            runtime,
            originalTitle,
            childProtectionId,
            childProtectionLevel,
            countries,
            mainGenre,
            longDescription,
            trailers,
            year,
            category,
            creationDate;
}
