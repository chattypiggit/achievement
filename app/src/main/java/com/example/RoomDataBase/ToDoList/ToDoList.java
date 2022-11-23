package com.example.RoomDataBase.ToDoList;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ToDoList {
    @PrimaryKey(autoGenerate = true)
    public int idx;

    @ColumnInfo(name = "start_date")
    public int start_date;

    @ColumnInfo(name = "end_date")
    public int end_date;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "content")
    public String content;

    @ColumnInfo(name = "color_selection")
    public int color_selection;
}
