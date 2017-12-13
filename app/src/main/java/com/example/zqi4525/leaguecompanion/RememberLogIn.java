package com.example.zqi4525.leaguecompanion;

/**
 * Created by Zqi4525 on 11/29/2017.
 */

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class RememberLogIn {

    @PrimaryKey
    public int id=0;
    public String ign;

    public RememberLogIn(int id, String ign) {
        this.id=id;
        this.ign = ign;
    }
}
