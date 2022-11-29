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

    public void setOwn(int idx, boolean owned){
        PetCheckInfo a = new PetCheckInfo(idx,owned);
        petCheckDao.insert(a);
    }

    public void setExp(int idx, int exp){
        PetCheckInfo a = new PetCheckInfo(idx,true,exp);
        petCheckDao.insert(a);
    }

    public void addExp(int idx, int exp){
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
