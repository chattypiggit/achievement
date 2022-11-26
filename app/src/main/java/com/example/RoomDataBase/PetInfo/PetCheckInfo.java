package com.example.RoomDataBase.PetInfo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class PetCheckInfo {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "idx")
    public int idx;

    @ColumnInfo(name = "is_owned")
    public boolean is_owned;


    @ColumnInfo(name = "current_exp")
    public int current_exp;

    public PetCheckInfo(int idx, boolean is_owned){
        this.idx = idx;
        this.is_owned = is_owned;
        this.current_exp = 0;
    }
    @Ignore
    public PetCheckInfo(int idx, boolean is_owned, int current_exp){
        this.idx = idx;
        this.is_owned = is_owned;
        this.current_exp = current_exp;
    }
}
