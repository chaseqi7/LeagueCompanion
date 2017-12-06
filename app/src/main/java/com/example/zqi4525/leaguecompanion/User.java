package com.example.zqi4525.leaguecompanion;

/**
 * Created by Zqi4525 on 11/29/2017.
 */

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    public final int id;
    public String name;
    public String password;


    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password=password;
    }
}
