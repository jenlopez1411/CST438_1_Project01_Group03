package com.nayelidj.cst438_1_project01_group03;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//update entity
@Entity(tableName = "Favorite")
public class Favorite {
    @PrimaryKey(autoGenerate = true)
    private int favoriteId;

    @ColumnInfo(name = "companyName")
    private String companyName;

    @ColumnInfo(name = "jobName")
    private String jobName;

    @ColumnInfo(name = "jobLabel")
    private String jobLabel;

    @ColumnInfo(name = "datePosted")
    private String datePosted;

    @ColumnInfo(name = "country")
    private String country;

    @ColumnInfo(name = "state")
    private String state;

    @ColumnInfo(name = "county")
    private String county;

    @ColumnInfo(name = "city")
    private String city;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "redirectUrl")
    private String redirectUrl;

    @ColumnInfo(name = "favoriteStatus")
    private Boolean favStat; //boolean

    public Favorite(String companyName, String jobName, String jobLabel, String datePosted, String country, String state, String county, String city, String description, String redirectUrl, Boolean favStat) {
        this.companyName = companyName;
        this.jobName = jobName;
        this.jobLabel = jobLabel;
        this.datePosted = datePosted;
        this.country = country;
        this.state = state;
        this.county = county;
        this.city = city;
        this.description = description;
        this.redirectUrl = redirectUrl;
        this.favStat = favStat;
    }



    public int getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobLabel() {
        return jobLabel;
    }

    public void setJobLabel(String jobLabel) {
        this.jobLabel = jobLabel;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Boolean getFavStat() {
        return favStat;
    }

    public void setFavStat(Boolean favStat) {
        this.favStat = favStat;
    }

    @Override
    public String toString() {
        return
                favoriteId + ". " +
                "Company Name: " + companyName  + ", \n" +
                "Job Name: " + jobName + ", \n"+
                        "Job Label: " + jobLabel + ", \n" +
                        "Date Posted: " + datePosted + ", \n" +
                        "Country: " + country + ", \n" +
                        "State: " + state + ", \n" +
                        "County: " + county + ", \n" +
                        "City: " + city + ", \n" +
                        "Description: " + description + ", \n"+
                        "Url: " + redirectUrl;
    }
}