package com.nayelidj.cst438_1_project01_group03;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavoriteDao {
    @Insert
    void addFavorite(Favorite fav);
    @Insert
    long[] addMultFavorite(Favorite...fav);

    @Query("SELECT * FROM Favorite")
    List<Favorite> getAllFavorite();
    @Query("SELECT COUNT(*) FROM Favorite")
    int countFavorite();
    @Query("SELECT * FROM Favorite where favoriteId=:favoriteId")
    List<Favorite> getFavorite(String favoriteId);
}

