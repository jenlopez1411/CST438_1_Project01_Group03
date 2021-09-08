package com.nayelidj.cst438_1_project01_group03;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version=1, exportSchema = false)
public abstract class UserDB extends RoomDatabase {
    public abstract UserDao UserD();
    private static UserDB sInstance;
    public static final String User = "user";

    public static synchronized UserDB getInstance(Context context){
        if (sInstance == null){
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    UserDB.class, "user.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }
    public void seed() {
        if (UserD().countUser() == 0){
            runInTransaction(new Runnable() {
                @Override
                public void run() {
                    //user added
                    User student = new User("student", "password");

                    UserD().addUser(student);
                }
            });
        }
    }
}
