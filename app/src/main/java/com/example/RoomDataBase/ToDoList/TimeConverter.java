package com.example.RoomDataBase.ToDoList;

import android.annotation.SuppressLint;

import androidx.room.TypeConverter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConverter {
    @TypeConverter
    public Date toString(long timestamp){
        return new Date(timestamp);
    }
    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
