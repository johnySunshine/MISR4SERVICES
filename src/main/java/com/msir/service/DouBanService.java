package com.msir.service;

public interface DouBanService {
    /**
     * 电影完整条目信息
     *
     * @param subjectId
     * @return
     */
    Object getMovieBySubjectId(String subjectId);

    /**
     * 影人信息
     *
     * @param celebrityId
     * @return
     */
    Object getCelebrityById(String celebrityId);

    /**
     * 影人作品
     *
     * @param celebrityId
     * @return
     */
    Object getCelebrityByIdWorks(String celebrityId);

    /**
     * 电影条目剧照
     *
     * @param subjectId
     * @return
     */
    Object getPhotoById(String subjectId);

    /**
     * 正在热映的影片
     *
     * @param city：中文
     * @return Object
     */
    Object getMovieProduce(String city);

    /**
     * 即将热映
     *
     * @param start 起始位置
     * @param count 总个数
     * @return Object
     */
    Object getMovieComingSoon(String start, String count);

    Object getMovieComingSoon();

    /**
     * 豆瓣top250
     *
     * @param start 起始位置
     * @param count 总个数
     * @return
     */
    Object top250(String start, String count);

    Object top250();

    /**
     * 一周口碑榜
     *
     * @return
     */
    Object MovieWeekly();

    /**
     * 电影条目搜索
     *
     * @param q
     * @return
     */
    Object getSearchWithDouBan(String q);

    Object getSearchWithDouBan(String q, String tag);

    Object getSearchWithDouBan(String q, String start, String count);

    Object getSearchWithDouBan(String q, String tag, String start, String count);
}
