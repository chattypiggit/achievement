package com.example.RoomDataBase.Achievement;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface AchievementCheckDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(AchievementCheck achievement);

    @Query("UPDATE AchievementCheck SET is_acquired = :is_acquired WHERE idx = :idx")
    void update(int idx, boolean is_acquired);

    @Query("SELECT * FROM AchievementCheck")
    List<AchievementCheck> get();
    @Query("SELECT * FROM AchievementCheck WHERE idx = :idx")
    AchievementCheck get(int idx);

}
