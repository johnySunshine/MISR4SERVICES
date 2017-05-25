package com.msir.service.impl;

import com.msir.dao.MovieDao;
import com.msir.pojo.Movie;
import com.msir.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/29.
 * MovieServiceImpl
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDao movieDao;

    public int insertMovie(Movie movie) {
        return movieDao.insertDao(movie);
    }

    public int deleteMovie(int moviesId) {
        return movieDao.deleteDao(moviesId);
    }

    public int updateMovie(Movie movie) {
        return movieDao.updateDao(movie);
    }

    public Movie getMovieById(int movieId) {
        return movieDao.getMovieById(movieId);
    }

    public List<Movie> getMoviesWithTabs(Integer offset, Integer size) {
        offset = (offset - 1) * size;
        return movieDao.getMoviesWithTabs(offset, size);
    }

    public List<Movie> fuzzyMoviesByName(String movieTitles) {
        return movieDao.fuzzyMoviesByName(movieTitles);
    }

    public int countMovie() {
        return movieDao.countMovie();
    }
}
