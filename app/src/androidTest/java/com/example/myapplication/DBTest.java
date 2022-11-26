package com.example.myapplication;

import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.RoomDataBase.Achievement.AchievementCheck;
import com.example.RoomDataBase.Achievement.AchievementCheckDataBase;
import com.example.RoomDataBase.ToDoList.ToDoList;
import com.example.RoomDataBase.ToDoList.ToDoListDataBase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

@RunWith(AndroidJUnit4.class)
public class DBTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        ToDoListDataBase todoList = ToDoListDataBase.getAppDatabase(appContext);
        ToDoList a = new ToDoList("시러","시러",new Date(0),new Date(1));
        a.idx = 2;

        todoList.toDoDao().update(a);
        for(ToDoList asdf : todoList.toDoDao().get()){
            Log.v("asdf",asdf.toString());
        }

    }
}
