package com.example.RoomDataBase.ToDoList;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class ToDoList {
    @PrimaryKey(autoGenerate = true)
    public int idx;

    @ColumnInfo(name = "start_date")
    public String start_date;

    @ColumnInfo(name = "end_date")
    public boolean end_date;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "location")
    public String location;

    @ColumnInfo(name = "color_selection")
    public int color_selection;
}
