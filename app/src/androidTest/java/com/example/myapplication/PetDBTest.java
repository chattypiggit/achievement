package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.RoomDataBase.Achievement.AchievementCheck;
import com.example.RoomDataBase.Achievement.AchievementCheckDataBase;
import com.example.RoomDataBase.PetInfo.PetCheckDataBase;
import com.example.RoomDataBase.PetInfo.PetCheckInfo;
import com.example.myapplication.helper.AchievementHelper;
import com.example.myapplication.helper.UserInfoHelper;

import java.util.List;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class PetDBTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.

        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AchievementHelper helper= new AchievementHelper(appContext);


        AchievementHelper a = new AchievementHelper(appContext);
        a.setOwnByIdx(1,true);
        List<AchievementCheck> ss = AchievementCheckDataBase.getAppDatabase(appContext).AchievementDao().get();
        for(AchievementCheck i : ss){
            Log.v("asdf", Integer.toString(i.idx));
        }

        Log.v("asdf", String.valueOf(helper.isAcquired(2)));


    }
}

