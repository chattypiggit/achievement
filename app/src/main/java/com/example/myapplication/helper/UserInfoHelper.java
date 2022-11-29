package com.example.myapplication.helper;

import android.content.Context;

import com.example.RoomDataBase.UserInfo.UserInfo;
import com.example.RoomDataBase.UserInfo.UserInfoDao;
import com.example.RoomDataBase.UserInfo.UserInfoDataBase;

import java.util.List;

public class UserInfoHelper {
    private Context context;
    UserInfoDao userInfoDao;
    public UserInfoHelper(Context context){
        this.context = context;
        this.userInfoDao = UserInfoDataBase.getAppDatabase(this.context).userInfoDao();
    }

    public int getLoginCount(){
        List<UserInfo> tt =  this.userInfoDao.get();
        if(tt.size() ==0){
            userInfoDao.insert(new UserInfo());
            return 1;
        }
        return tt.get(0).login_count;
    }
    public int getEvolutionCount(){
        List<UserInfo> tt =  this.userInfoDao.get();
        if(tt.size() ==0){
            userInfoDao.insert(new UserInfo());
            return 0;
        }
        return tt.get(0).evolution_count;
    }

    public void addLoginCount(){
        List<UserInfo> tt =  this.userInfoDao.get();
        if(tt.size() ==0){
            userInfoDao.insert(new UserInfo());
            return;
        }
        tt.get(0).login_count ++;
        userInfoDao.update(tt.get(0));
    }
    public void addPetEvolutionCount(){
        List<UserInfo> tt =  this.userInfoDao.get();
        if(tt.size() ==0){
            userInfoDao.insert(new UserInfo());
            return;
        }
        tt.get(0).evolution_count++;
        userInfoDao.update(tt.get(0));
    }


}
