package com.example.RoomDataBase.UserInfo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;



@Database(entities = {UserInfo.class}, version =  1, exportSchema = false)
public abstract class UserInfoDataBase extends RoomDatabase {
    private static UserInfoDataBase Instance;
    public abstract UserInfoDao userInfoDao();

    public static UserInfoDataBase getAppDatabase(Context context){
        if(Instance == null){
            Instance = Room.databaseBuilder(context, UserInfoDataBase.class , "user_info").allowMainThreadQueries().build();
        }
        return  Instance;
    }
    public static void destroy() {
        Instance.close();
    }
}
