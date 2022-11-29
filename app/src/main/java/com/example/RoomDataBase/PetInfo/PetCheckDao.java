package com.example.RoomDataBase.PetInfo;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

@Dao
public interface PetCheckDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE	)
    void insert(PetCheckInfo petInfo);

    @Query("SELECT * FROM PetCheckInfo")
    List<PetCheckInfo> get();

    @Query("SELECT * FROM PetCheckInfo WHERE idx = :idx")
    PetCheckInfo getByIdx(int idx);

}
