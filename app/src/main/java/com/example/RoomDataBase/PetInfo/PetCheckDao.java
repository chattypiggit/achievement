package com.example.RoomDataBase.PetInfo;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import java.util.List;

@Dao
public interface PetCheckDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE	)
    void insert(PetCheckInfo petInfo);
    @Query("UPDATE PetCheckInfo SET is_owned = :is_owned WHERE idx = :idx")
    void update(int idx, boolean is_owned);
    @Query("SELECT * FROM PetCheckInfo")
    List<PetCheckInfo> get();
    @Query("SELECT * FROM PetCheckInfo WHERE idx = :idx")
    PetCheckInfo get(int idx);
}
