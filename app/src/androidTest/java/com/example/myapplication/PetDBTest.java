package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.RoomDataBase.PetInfo.PetCheckDataBase;
import com.example.RoomDataBase.PetInfo.PetCheckInfo;
import com.example.myapplication.helper.UserInfoHelper;

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
        UserInfoHelper user_helper = new UserInfoHelper(appContext);

        user_helper.addLoginCount();

        Log.v("asdf", Integer.toString(user_helper.getLoginCount()));


        
    }
}

