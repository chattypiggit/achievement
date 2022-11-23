package com.example.RoomDataBase.PetInfo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PetInfo {


    @NonNull
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "exp")
    public int exp;

    @ColumnInfo(name = "max_exp")
    public int max_exp;

    @ColumnInfo(name = "is_owned")
    public boolean is_owned;

    @ColumnInfo(name = "flavor_text")
    public String flavor_text;

    @ColumnInfo(name = "line1")
    public String line1;

    @ColumnInfo(name = "line2")
    public String line2;

    @ColumnInfo(name = "next_idx")
    public int next_idx;

    @ColumnInfo(name = "img_source")
    public int img_source;
}
