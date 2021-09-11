package com.nayelidj.cst438_1_project01_group03;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Favorite.class}, version=1, exportSchema = false)
public abstract class FavoriteDB extends RoomDatabase {
    public abstract FavoriteDao FavD();
    private static FavoriteDB sInstance;
    public static final String Favorite = "fav";

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
            runInTransaction(new Runnable() {
                @Override
                public void run() {
                    //favorite added
                }
            });
        }
    }
}
