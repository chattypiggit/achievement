package com.example.myapplication;

import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.RoomDataBase.ToDoList.ToDoList;
import com.example.RoomDataBase.ToDoList.ToDoListDataBase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.util.Date;

@RunWith(AndroidJUnit4.class)
public class ToDoListTest {
    @Test
    public void useAppContext() throws ParseException {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        ToDoListDataBase todoList = ToDoListDataBase.getAppDatabase(appContext);

        for(ToDoList asdf : todoList.toDoDao().get()){
            Log.v("asdf",asdf.toString());
        }
        for(ToDoList asdf : todoList.toDoDao().get()){

            todoList.toDoDao().delete(asdf);
        }
    }
}
