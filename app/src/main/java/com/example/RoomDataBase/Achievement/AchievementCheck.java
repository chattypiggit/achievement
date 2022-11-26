package com.example.RoomDataBase.Achievement;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AchievementCheck {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "idx")
    public int idx;
    @ColumnInfo(name = "is_acquired")
    public boolean is_acquired;



    public AchievementCheck(int idx, boolean is_acquired) {
        this.idx = idx;
        this.is_acquired = is_acquired;

    }
}
