package com.nayelidj.cst438_1_project01_group03;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public static final String DB_NAME = "USER_DATABASE";
    private static UserDatabase object;
    public abstract UserDao getUserDao();

    public UserDatabase userDatabase(final Context context) {
        if(object == null){
            object = Room.databaseBuilder(context, UserDatabase.class, DB_NAME).build();

        }
        return object;
    }
}
