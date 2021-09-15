package com.nayelidj.cst438_1_project01_group03;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CreateAcct.class}, version = 1, exportSchema = false)
public abstract class CreateAcctDatabase extends RoomDatabase {
    public static final String DB_NAME = "CREATEACCOUNT_DATABASE";
    private static CreateAcctDatabase object;
    public abstract CreateAcctDao getCreateAcctDao();

    public CreateAcctDatabase CreateAcctDatabase(final Context context) {
        if(object == null){
            object = Room.databaseBuilder(context, CreateAcctDatabase.class, DB_NAME).build();

        }
        return object;
    }
}
