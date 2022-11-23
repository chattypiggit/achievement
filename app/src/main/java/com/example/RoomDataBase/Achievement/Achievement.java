package com.example.RoomDataBase.Achievement;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Achievement {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    public String name;


    @ColumnInfo(name = "is_acquired")
    public boolean is_acquired;

    @ColumnInfo(name = "flavor_text")
    public String flavor_text;


    @ColumnInfo(name = "acquired_date")
    public String acquired_date;

    @ColumnInfo(name = "img_source")
    public String img_source;


    public Achievement(@NonNull String name, boolean is_acquired, String flavor_text, String acquired_date, String img_source) {
        this.name = name;
        this.is_acquired = is_acquired;
        this.flavor_text = flavor_text;
        this.acquired_date = acquired_date;
        this.img_source = img_source;
    }
}
