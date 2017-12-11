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
    public String email;
    public String password;


    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password=password;
    }
}
