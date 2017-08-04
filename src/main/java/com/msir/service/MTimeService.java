package com.msir.service;

/**
 * Created by Fantasy on 2017/8/3.
 */
public interface MTimeService {
    /**
     * 以下从时光网上面获取的资源信息
     */
    Object getMTimeShowTime(int locationId);

    Object getMTimeMovieComingNew(int locationId);

    Object getMTimeMovieDetail(int locationId, String movieId);

    Object getMTimeMovieCreditsWithTypes(int movieId);

    Object getMTimeVideo(int pageIndex, int movieId);

    Object getMTimeImageAll(int movieId);

}
