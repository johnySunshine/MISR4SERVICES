package com.soecode.lyf.dto;

import com.soecode.lyf.entity.CastAndCrew;
import com.soecode.lyf.entity.Images;
import com.soecode.lyf.entity.MajorRating;
import com.soecode.lyf.entity.Movie;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/22.
 * 影片的基本信息
 * <p/>

 */
public class ContentInformation {
    private Movie movie;
    private List<CastAndCrew> castAndCrews;
    private List<Images> images;
    private MajorRating majorRating;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<CastAndCrew> getCastAndCrews() {
        return castAndCrews;
    }

    public void setCastAndCrews(List<CastAndCrew> castAndCrews) {
        this.castAndCrews = castAndCrews;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public MajorRating getMajorRating() {
        return majorRating;
    }

    public void setMajorRating(MajorRating majorRating) {
        this.majorRating = majorRating;
    }
}
