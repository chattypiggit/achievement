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

import java.util.Date;

@RunWith(AndroidJUnit4.class)
public class ToDoListTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        ToDoListDataBase todoList = ToDoListDataBase.getAppDatabase(appContext);
        //일정을 추가한다.
        ToDoList newToDo = new ToDoList("시러","시러",new Date(0),new Date(1));
        todoList.toDoDao().update(newToDo);
        
        //todoList.toDoDao().get(int idx) 특정 일정 가져오기
        //todoList.toDoDao().get()전체 가져오기

        //일정을 추가한다.
        ToDoList oldToDo = todoList.toDoDao().get(0);
        oldToDo.title = "제목 수정1";
        oldToDo.content = "내용 수정1";

        //idx기준으로 수정
        todoList.toDoDao().update(oldToDo);

        //todoList.toDoDao().delete(oldToDo) 하면 지워짐
        //또는 todoList.toDoDao().delete(int idx)도 가능
        for(ToDoList asdf : todoList.toDoDao().get()){
            Log.v("asdf",asdf.toString());
        }

    }
}
