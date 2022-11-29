package com.example.RoomDataBase.Achievement;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {AchievementCheck.class}, version =  1, exportSchema = false)

public abstract class AchievementCheckDataBase extends RoomDatabase {
    private static AchievementCheckDataBase Instance;
    public abstract AchievementCheckDao AchievementDao();
    public static AchievementCheckDataBase getAppDatabase(Context context){
        if(Instance == null){
            Instance = Room.databaseBuilder(context, AchievementCheckDataBase.class , "achievement_check").allowMainThreadQueries()
                    .build();
        }
        return  Instance;
    }
    public static void destroy() {
        Instance.close();
    }

}