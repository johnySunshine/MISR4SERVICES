package com.msir.dao;

import com.msir.entity.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/22.
 * 操作数据库
 */
public interface MovieDao extends SuperBasicDao<Movie> {

    int insertDao(Movie movie);

    int deleteDao(@Param("moviesId") int moviesId);

    int updateDao(Movie movie);

    Movie getMovieById(@Param("movieId") int movieId);

    List<Movie> getMoviesWithTabs(@Param("offset") Integer offset, @Param("size") Integer size);

    List<Movie> fuzzyMoviesByName(@Param("movieTitles") String movieTitles);

    int countMovie();

}
