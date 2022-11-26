package com.example.RoomDataBase.ToDoList;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class ToDoList {
    @PrimaryKey(autoGenerate = true)
    public int idx;

    @ColumnInfo(name = "start_date")
    public Date start_date;

    @ColumnInfo(name = "end_date")
    public Date end_date;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "content")
    public String content;



    public ToDoList(String title, String content, Date start_date,Date end_date){
        this.content =content;
        this.title = title;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public ToDoList(String title, String content, Date start_date,Date end_date, int idx){
        this.content =content;
        this.title = title;
        this.start_date = start_date;
        this.end_date = end_date;
        this.idx = idx;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "idx=" + idx +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
