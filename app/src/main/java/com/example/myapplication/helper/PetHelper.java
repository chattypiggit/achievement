package com.example.myapplication.helper;

import android.content.Context;

import com.example.RoomDataBase.PetInfo.PetCheckDao;
import com.example.RoomDataBase.PetInfo.PetCheckDataBase;
import com.example.RoomDataBase.PetInfo.PetCheckInfo;

public class PetHelper {
    PetCheckDao petCheckDao;

    public PetHelper(Context context){
        PetCheckDao petCheckDao =  PetCheckDataBase.getAppDatabase(context).petInfoDao();
    }

    public boolean isOwnedByIdx(int idx){
        return petCheckDao.getByIdx(idx) == null;
    }

    public int  getExpByIdx(int idx){
        if(isOwnedByIdx(idx)){
            return -1;
        }
        return petCheckDao.getByIdx(idx).current_exp;
    }
    public void setOwnByIdx(int idx, boolean owned){
        PetCheckInfo a = new PetCheckInfo(idx,owned);
        petCheckDao.insert(a);
    }

    public void setExpByIdx(int idx, int exp){
        PetCheckInfo a = new PetCheckInfo(idx,true,exp);
        petCheckDao.insert(a);
    }

    public void addExpByIdx(int idx, int exp){
        PetCheckInfo a = petCheckDao.getByIdx(idx);
        if(a ==null){
            a = new PetCheckInfo(idx,true, exp);
        }
        else{
            a.current_exp +=exp;
        }

        petCheckDao.insert(a);
    }
}
