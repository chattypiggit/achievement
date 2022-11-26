package com.example.myapplication;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.RoomDataBase.PetInfo.PetCheckDataBase;
import com.example.RoomDataBase.PetInfo.PetCheckInfo;

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
        PetCheckDataBase db = PetCheckDataBase.getAppDatabase(appContext);
        
        //0번 인덱스 펫 소유를 true로 한다. 자세한 내용은 pet_info.csv참고
        PetCheckInfo a = new PetCheckInfo(0, true);
        //데이터 집어넣기
        db.petInfoDao().insert(a);
        
    }
}

