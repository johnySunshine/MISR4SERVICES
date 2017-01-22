package com.soecode.lyf.dao;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Movie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/22.
 */
public class MovieDaoTest extends BaseTest {
    @Autowired
    private MovieDao movieDao;

    @Test
    public void TestMovieDao(){
        List<Movie> movies = movieDao.queryDao();
        System.out.println(movies);
    }
}
