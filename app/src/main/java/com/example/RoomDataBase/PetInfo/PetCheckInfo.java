package com.example.RoomDataBase.PetInfo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PetCheckInfo {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "idx")
    public int idx;

    @ColumnInfo(name = "is_owned")
    public boolean is_owned;

    public PetCheckInfo(int idx, boolean is_owned){
        this.idx = idx;
        this.is_owned = is_owned;
    }

}
