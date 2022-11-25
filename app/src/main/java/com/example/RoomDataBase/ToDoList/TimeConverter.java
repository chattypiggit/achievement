package com.example.RoomDataBase.ToDoList;

import android.annotation.SuppressLint;

import androidx.room.TypeConverter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeConverter {
    @TypeConverter
    public String toString(long timestamp){
        @SuppressLint("SimpleDateFormat") SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        return originalFormat.format(timestamp);
    }
    @TypeConverter
    public long toTimeStamp(String date){
        Timestamp timestamp = Timestamp.valueOf(date);
        return timestamp.getTime();
    }
}
