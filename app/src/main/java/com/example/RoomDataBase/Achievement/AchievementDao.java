package com.example.RoomDataBase.Achievement;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.RoomDataBase.PetInfo.PetInfo;

import java.util.List;


@Dao
public interface AchievementDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Achievement achievement);

    @Query("UPDATE achievement SET is_acquired = :is_acquired WHERE name = :name")
    void update(String name, boolean is_acquired);

    @Update
    void update(Achievement achievement);

    @Delete
    void delete(Achievement achievement);

    @Query("SELECT * FROM achievement")

    List<Achievement> get();

    @Query("SELECT * FROM achievement WHERE name = :name")
    Achievement get(String name);

}
