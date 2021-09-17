package com.nayelidj.cst438_1_project01_group03;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CreateAcctDao {
    @Insert
    void insert(CreateAcct createAcct);

    @Update
    void update(CreateAcct createAcct);

    @Delete
    void delete(CreateAcct createAcct);

    @Query("DELETE FROM createAcct_table")
    void deleteAllUsers();

    @Query("SELECT * FROM createAcct_table ORDER BY id ASC")
    List<CreateAcct> getAllUsers();

    @Query("SELECT * FROM createAcct_table WHERE username = :username")
    CreateAcct getUser(String username);

    @Query("SELECT * FROM createAcct_table WHERE password = :password")
    CreateAcct getPassword(String password);
}
