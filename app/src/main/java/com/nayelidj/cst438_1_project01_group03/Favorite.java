package com.nayelidj.cst438_1_project01_group03;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Favorite")
public class Favorite {
    @PrimaryKey(autoGenerate = true)
    private int favoriteId;

    @ColumnInfo(name = "jobName")
    private String jobName;

    @ColumnInfo(name = "favoriteStatus")
    private Boolean favStat; //boolean

    public Favorite(String jobName, Boolean favStat){
        this.jobName = jobName;
        this.favStat = favStat;
    }

    public int getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Boolean getFavStat() {
        return favStat;
    }

    public void setFavStat(Boolean favStat) {
        this.favStat = favStat;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public String toString(){
        return jobName;
    }
}
