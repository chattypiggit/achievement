package com.example.RoomDataBase.ToDoList;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;


import com.example.RoomDataBase.PetInfo.PetCheckInfo;

import java.util.Date;
import java.util.List;

@Dao
public interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE	)
    void insert(ToDoList toDoList);

    @Update
    void update(ToDoList toDoList);

    @Query("SELECT * FROM ToDoList")
    List<ToDoList> get();

    @Query("SELECT * FROM ToDoList where date=:date")
    List<ToDoList> getByDate(String date);


    @Query("SELECT * FROM ToDoList WHERE idx = :idx")
    ToDoList getByIdx(int idx);

    @Query("Delete from ToDoList WHERE idx = :idx")
    void deleteByIdx(int idx);
    @Delete
    void delete(ToDoList toDoList);
}
