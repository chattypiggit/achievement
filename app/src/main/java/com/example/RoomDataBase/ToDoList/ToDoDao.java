package com.example.RoomDataBase.ToDoList;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;


import com.example.RoomDataBase.PetInfo.PetCheckInfo;

import java.util.List;

@Dao
public interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE	)
    void insert(ToDoList toDoList);

    @Update
    void update(ToDoList toDoList);

    @Query("SELECT * FROM ToDoList")
    List<ToDoList> get();

    @Query("SELECT * FROM ToDoList WHERE idx = :idx")
    ToDoList get(int idx);

    @Query("Delete from ToDoList WHERE idx = :idx")
    void delete(int idx);
    @Delete
    void delete(ToDoList toDoList);
}
