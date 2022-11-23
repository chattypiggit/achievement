package com.example.RoomDataBase.PetInfo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {PetInfo.class}, version =  1, exportSchema = false)
public abstract class PetInfoDatabase  extends RoomDatabase {
    private static PetInfoDatabase Instance;
    public abstract PetDao petInfoDao();

    public static PetInfoDatabase getAppDatabase(Context context){
        if(Instance == null){
            Instance = Room.databaseBuilder(context, PetInfoDatabase.class , "PetInfo").build();
        }
        return  Instance;
    }
    public static void destroy() {
        Instance.close();
    }

}
