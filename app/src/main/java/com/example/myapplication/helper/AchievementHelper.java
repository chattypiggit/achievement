package com.example.myapplication.helper;

import android.content.Context;

import com.example.RoomDataBase.Achievement.AchievementCheck;
import com.example.RoomDataBase.Achievement.AchievementCheckDao;
import com.example.RoomDataBase.Achievement.AchievementCheckDataBase;

public class AchievementHelper {
    AchievementCheckDao achievementCheckDao;

    public AchievementHelper(Context context){
        AchievementCheckDao achievementCheckDao =  AchievementCheckDataBase.getAppDatabase(context).AchievementDao();
    }

    public boolean isOwnedByIdx(int idx){
        return achievementCheckDao.getByIdx(idx) == null;
    }

    public void setOwnByIdx(int idx, boolean owned){
        AchievementCheck a = new AchievementCheck(idx,owned);
        achievementCheckDao.insert(a);
    }

}
