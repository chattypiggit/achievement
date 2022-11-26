package com.example.RoomDataBase.ToDoList;

import android.annotation.SuppressLint;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class ToDoList {
    @PrimaryKey(autoGenerate = true)
    public int idx;

    @ColumnInfo(name = "content")
    public String content;

    @ColumnInfo(name = "date")
    public Date date;



    public ToDoList(String content, String dateText) throws ParseException {
        this.content =content;
        String DEFAULT_PATTERN = "yyyy-MM-dd";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat(DEFAULT_PATTERN);
        this.date = format.parse(dateText);
    }

    public ToDoList(String content, Date date){
        this.content = content;
        this.date = date;
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
