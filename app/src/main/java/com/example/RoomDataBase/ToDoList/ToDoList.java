package com.example.RoomDataBase.ToDoList;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class ToDoList {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int idx;

    @ColumnInfo(name = "content")
    public String content;

    @ColumnInfo(name = "date")
    public String date;

    public ToDoList(String content, String date) {
        this.content =content;
        this.date = date;
    }

    @Ignore
    public ToDoList(String content, Date date){
        this.content = content;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        this.date = simpleDateFormat.format(date);
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "idx=" + idx +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}
