package com.msir.service;

import com.msir.entity.Movie;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/29.
 */
public interface MovieService {

    int insertMovie(Movie movie);

    int deleteMovie(int moviesId);

    int updateMovie(Movie movie);

    Movie getMovieById(int movieId);

    List<Movie> getMoviesWithTabs(Integer offset,Integer size);

    List<Movie> fuzzyMoviesByName(String movieTitles);

    int countMovie();
}
