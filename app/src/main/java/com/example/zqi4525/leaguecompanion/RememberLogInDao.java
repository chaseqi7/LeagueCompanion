package com.example.zqi4525.leaguecompanion;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Zqi4525 on 11/29/2017.
 */

@Dao
public interface RememberLogInDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RememberLogIn rememberLogIn);

    @Query("select ign from RememberLogIn where id = 0")
    public String getLastUser();

    @Query("delete from RememberLogIn; ")
    void removeAllUsers();
}
