package com.example.myapplication.helper;

import android.content.Context;
import android.util.Log;

import com.example.RoomDataBase.Achievement.AchievementCheck;
import com.example.RoomDataBase.Achievement.AchievementCheckDao;
import com.example.RoomDataBase.Achievement.AchievementCheckDataBase;

public class AchievementHelper {
    AchievementCheckDao achievementCheckDao;

    public AchievementHelper(Context context){
         this.achievementCheckDao =  AchievementCheckDataBase.getAppDatabase(context).AchievementDao();
    }

    public boolean isAcquired(int idx){
        return achievementCheckDao.getByIdx(idx) != null;
    }

    public void setOwnByIdx(int idx, boolean owned){
        AchievementCheck a = new AchievementCheck(idx,owned);
        achievementCheckDao.insert(a);
    }

}
