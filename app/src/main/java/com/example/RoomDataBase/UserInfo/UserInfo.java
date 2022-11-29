package com.example.RoomDataBase.UserInfo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public interface UserInfo {
    @ColumnInfo(name = "login_count")
    public int login_count = 0;

}
