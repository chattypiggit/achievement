package com.example.RoomDataBase.UserInfo;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;


import com.example.RoomDataBase.PetInfo.PetCheckInfo;
import com.example.RoomDataBase.ToDoList.ToDoList;

import java.util.Date;
import java.util.List;

@Dao
public interface UserInfoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(UserInfo userInfo);

    @Update
    void update(UserInfo userInfo);

    @Query("SELECT * FROM UserInfo")
    List<UserInfo> get();




}
