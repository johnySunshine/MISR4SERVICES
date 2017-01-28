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
    public void TestMovieDao() {
        List<Movie> movies = movieDao.queryDao();
        System.out.println(movies);
    }

    @Test
    public void TestAddMovieDao() {
        Movie movie = new Movie();
        movie.setTitle("影片标题");
        movie.setCategory("影片类别");
        movie.setChildProtectionDisplayName("影片保护等级显示");
        movie.setChildProtectionId("影片儿童保护id");
        movie.setCountries("影片国家");
        movie.setCreationDate("影片创建时间");
        movie.setLongDescription("影片描述");
        movie.setMainGenre("影片主要类别");
        movie.setRuntime("影片时长");
        movie.setYear("影片年份");
        movie.setOriginalTitle("影片原标题");
        Integer i = movieDao.insertDao(movie);
        System.out.println(i);
    }

}
