package com.example.RoomDataBase.Achievement;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Achievement.class}, version =  1, exportSchema = false)

public abstract class AchievementDataBase extends RoomDatabase {
    private static AchievementDataBase Instance;
    public abstract AchievementDao AchievementDao();
    public static AchievementDataBase getAppDatabase(Context context){
        if(Instance == null){
            Instance = Room.databaseBuilder(context, AchievementDataBase.class , "Achievement")
                    .build();
        }
        return  Instance;
    }
    public static void destroy() {
        Instance.close();
    }

}