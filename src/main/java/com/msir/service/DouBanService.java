package com.msir.service;

public interface DouBanService {
    Object getMovieBySubjectId(String subjectId);

    Object getCelebrityById(String celebrityId);

    /**
     * 正在热映的影片
     *
     * @param city：中文
     * @return
     */
    Object getmovieProduce(String city);

    Object movieComingSoon(String city);
}
