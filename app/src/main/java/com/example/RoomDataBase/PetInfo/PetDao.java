package com.example.RoomDataBase.PetInfo;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

@Dao
public interface PetDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE	)
    void insert(PetInfo petInfo);
    @Query("UPDATE petinfo SET is_owned = :is_owned WHERE name = :name")
    void update(String name, boolean is_owned);
    @Update
    void update(PetInfo petInfo);
    @Delete
    void delete(PetInfo petInfo);
    @Query("SELECT * FROM PetInfo")
    List<PetInfo> get();
    @Query("SELECT * FROM PetInfo WHERE name = :name")
    PetInfo get(String name);
}
