
package com.nayelidj.cst438_1_project01_group03;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Favorite.class}, version=1, exportSchema = false)
public abstract class FavoriteDB extends RoomDatabase {
    public abstract FavoriteDao FavD();
    private static FavoriteDB sInstance;

    public static synchronized FavoriteDB getInstance(Context context){
        if (sInstance == null){
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    FavoriteDB.class, "favorite.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }
    public void seed() {
        if (FavD().countFavorite() == 0){
            runInTransaction(() -> {
                com.nayelidj.cst438_1_project01_group03.Favorite test1 = new Favorite("Google", "Software Engineer", "Computer Science", "September 23, 2021", "United States", "California", "Monterey County", "Greenfield", "It's cool", "google.com", true);
                FavD().addFavorite(test1);
//                                public Favorite(String companyName, String jobName, String jobLabel, String datePosted, String country, String state, String county, String city, String description, String redirectUrl, Boolean favStat) {

                });
            //add value
            //to test
        }
    }
}