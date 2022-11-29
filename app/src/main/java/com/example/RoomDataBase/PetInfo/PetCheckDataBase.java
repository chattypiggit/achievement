package com.example.RoomDataBase.PetInfo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {PetCheckInfo.class}, version =  2, exportSchema = false)
public abstract class PetCheckDataBase extends RoomDatabase {
    private static PetCheckDataBase Instance;
    public abstract PetCheckDao petInfoDao();

    public static PetCheckDataBase getAppDatabase(Context context){
        if(Instance == null){
            Instance = Room.databaseBuilder(context, PetCheckDataBase.class , "pet_check").allowMainThreadQueries().build();
        }
        return  Instance;
    }
    public static void destroy() {
        Instance.close();
    }

}
