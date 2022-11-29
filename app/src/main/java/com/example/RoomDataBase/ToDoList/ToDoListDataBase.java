package com.example.RoomDataBase.ToDoList;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.RoomDataBase.PetInfo.PetCheckDao;
import com.example.RoomDataBase.PetInfo.PetCheckDataBase;
import com.example.RoomDataBase.PetInfo.PetCheckInfo;

@Database(entities = {ToDoList.class}, version =  5, exportSchema = false)
public abstract class ToDoListDataBase extends RoomDatabase {
    private static ToDoListDataBase Instance;
    public abstract ToDoDao toDoDao();

    public static ToDoListDataBase getAppDatabase(Context context){
        if(Instance == null){
            Instance = Room.databaseBuilder(context, ToDoListDataBase.class , "todo_list").allowMainThreadQueries().build();
        }
        return  Instance;
    }
    public static void destroy() {
        Instance.close();
    }
}