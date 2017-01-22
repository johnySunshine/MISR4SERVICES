package com.soecode.lyf.entity;

/**
 * Created by Fantasy on 2017/1/22.
 * 电影实体类
 * <p/>
 * title,影片标题
 * runtime,影片时长
 * originalTitle,影片原标题
 * childProtectionId,影片儿童保护id
 * childProtectionLevel,影片儿童保护等级
 * childProtectionDisplayName,影片保护等级显示
 * countries,影片国家
 * mainGenre,影片主要类别
 * longDescription,影片描述
 * trailers,影片片花
 * year,影片年份
 * category,影片类别
 * creationDate;影片创建时间
 * castAndCrews:影片演员
 * images:影片海报
 * majorRating:影片主要评分
 */
public class Movie {
    private int movieId;
    private String
            title,
            runtime,
            originalTitle,
            childProtectionDisplayName,
            childProtectionId,
            childProtectionLevel,
            countries,
            mainGenre,
            longDescription,
            trailers,
            year,
            category,
            creationDate;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getChildProtectionDisplayName() {
        return childProtectionDisplayName;
    }

    public void setChildProtectionDisplayName(String childProtectionDisplayName) {
        this.childProtectionDisplayName = childProtectionDisplayName;
    }

    public String getChildProtectionId() {
        return childProtectionId;
    }

    public void setChildProtectionId(String childProtectionId) {
        this.childProtectionId = childProtectionId;
    }

    public String getChildProtectionLevel() {
        return childProtectionLevel;
    }

    public void setChildProtectionLevel(String childProtectionLevel) {
        this.childProtectionLevel = childProtectionLevel;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getMainGenre() {
        return mainGenre;
    }

    public void setMainGenre(String mainGenre) {
        this.mainGenre = mainGenre;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getTrailers() {
        return trailers;
    }

    public void setTrailers(String trailers) {
        this.trailers = trailers;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
