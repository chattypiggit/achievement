package com.example.myapplication;

import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.RoomDataBase.Achievement.Achievement;
import com.example.RoomDataBase.Achievement.AchievementDataBase;
import com.example.RoomDataBase.PetInfo.PetInfo;
import com.example.RoomDataBase.PetInfo.PetInfoDatabase;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DBTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AchievementDataBase db = AchievementDataBase.getAppDatabase(appContext);
        Achievement a = new Achievement("로그인 100번", false,"ㅇㅅㅇ", null,null);
        db.AchievementDao().insert(a);
        Achievement c = db.AchievementDao().get("asfd");
        db.AchievementDao().update("로그인 100번", true);
        Log.v("test", db.AchievementDao().get("로그인 100번").is_acquired ? "t" : "f"  );
    }
}
