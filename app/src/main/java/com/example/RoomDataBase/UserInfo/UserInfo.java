package com.example.RoomDataBase.UserInfo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.PrimaryKey;

@Entity
public class UserInfo {
    @NonNull
    @PrimaryKey(autoGenerate = true)

    public int idx;


    @ColumnInfo(name = "login_count")
    public int login_count = 1;
    @ColumnInfo(name = "evolution_count")
    public int evolution_count = 0;

    public UserInfo() {
        this.idx = 1;
        this.login_count = 1;
        this.evolution_count = 0;
    }

}
