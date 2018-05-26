package com.sda.kino.project.reservation.dto;

import com.sda.kino.project.model.MovieGenre;


public class ReservationDto {
    private Integer seanceId;
    private String seanceDataStart;
    private String seanceDataStartTime;
    private double seancePrice;
    private Integer movieId;
    private Integer userId;
    private String userFirstName;
    private String userLastName;
    private String userLogin;
    private String userEmail;
    private String movieTitle;
    private String movieDescription;
    private String yearOfMovieProduction;

    public Integer getSeanceId() {
        return seanceId;
    }

    public void setSeanceId(Integer seanceId) {
        this.seanceId = seanceId;
    }

    public String getSeanceDataStart() {
        return seanceDataStart;
    }

    public void setSeanceDataStart(String seanceDataStart) {
        this.seanceDataStart = seanceDataStart;
    }

    public String getSeanceDataStartTime() {
        return seanceDataStartTime;
    }

    public void setSeanceDataStartTime(String seanceDataStartTime) {
        this.seanceDataStartTime = seanceDataStartTime;
    }

    public double getSeancePrice() {
        return seancePrice;
    }

    public void setSeancePrice(double seancePrice) {
        this.seancePrice = seancePrice;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getYearOfMovieProduction() {
        return yearOfMovieProduction;
    }

    public void setYearOfMovieProduction(String yearOfMovieProduction) {
        this.yearOfMovieProduction = yearOfMovieProduction;
    }
}
