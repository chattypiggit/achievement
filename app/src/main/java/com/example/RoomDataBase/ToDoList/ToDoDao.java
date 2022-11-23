package com.example.RoomDataBase.ToDoList;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

public interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE	)
    void insert(ToDoList petInfo);
//    @Query("UPDATE ToDoList SET    WHERE idx = :idx)
//    void update(int idx);
    @Update
    void update(ToDoList petInfo);
    @Delete
    void delete(ToDoList petInfo);
    @Query("SELECT * FROM PetInfo")
    List<ToDoList> get();
    @Query("SELECT * FROM PetInfo WHERE name = :name")
    ToDoList get(String name);
}
