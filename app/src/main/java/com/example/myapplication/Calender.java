package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.RoomDataBase.ToDoList.ToDoList;
import com.example.RoomDataBase.ToDoList.ToDoListDataBase;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.util.Locale;
import java.util.Objects;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.util.Log;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Calender extends Fragment {

    private final SimpleDateFormat dateFormatForDisplaying = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
    private final SimpleDateFormat dateFormatForMonth = new SimpleDateFormat("yyyy년 MM월", Locale.KOREA);
    private final SimpleDateFormat dateFormatForMonth2 = new SimpleDateFormat("yyyy-MM", Locale.KOREA);
    @SuppressLint("SimpleDateFormat")
    private final SimpleDateFormat dbFormat = new SimpleDateFormat("yyyyMMdd");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //((MainActivity)getActivity()).setActionBarTitle("캘린더");
        return inflater.inflate(R.layout.fragment_cal, container, false);
    }

    //fragment에서 findviewbyid를 사용하기 위해 선언
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CompactCalendarView compactCalendarView = (CompactCalendarView) view.findViewById(R.id.compactcalendar_view);

        TextView textView_month = (TextView) view.findViewById(R.id.textView_month);
        TextView textView_result = (TextView) view.findViewById(R.id.textView_result);
        TextView textView_tmpList1 = (TextView) view.findViewById(R.id.textview_tmpList1);
        TextView textView_tmpList2 = (TextView) view.findViewById(R.id.textview_tmpList2);
        TextView textView_tmpList3 = (TextView) view.findViewById(R.id.textview_tmpList3);


        textView_month.setText(dateFormatForMonth.format(compactCalendarView.getFirstDayOfCurrentMonth()));
        compactCalendarView.setFirstDayOfWeek(Calendar.MONDAY);

        // 날짜 클릭 이벤트 관련 코드
        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                ToDoListDataBase toDoListDataBase = ToDoListDataBase.getAppDatabase(getContext());
                Log.v("asdf", dbFormat.format(dateClicked));
                List<ToDoList> tt=toDoListDataBase.toDoDao().getByDate(dbFormat.format(dateClicked));

                List<Event> events = compactCalendarView.getEvents(dateClicked);
                //날짜 호출시 내용 표시
                if(events.size() == 1){
                    textView_tmpList1.setText(tt.get(0).content);
                    textView_tmpList2.setText("Empty");
                    textView_tmpList3.setText("Empty");
                }
                else if(events.size() == 2){
                    textView_tmpList1.setText(tt.get(0).content);
                    textView_tmpList2.setText(tt.get(1).content);
                    textView_tmpList3.setText("Empty");
                }
                else if(events.size() == 3){
                    textView_tmpList1.setText(tt.get(0).content);
                    textView_tmpList2.setText(tt.get(1).content);
                    textView_tmpList3.setText(tt.get(2).content);
                }
                else {
                    textView_tmpList1.setText("Empty");
                    textView_tmpList2.setText("Empty");
                    textView_tmpList3.setText("Empty");
                }
                textView_tmpList1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(textView_tmpList1.getText().toString().equals("Empty")){
                            Toast.makeText(getActivity(), "삭제할 일정이 없습니다.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            AlertDialog dialog = builder.setTitle("일정을 삭제하겠습니까?")
                                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            // 확인 클릭 시 실행할 거 작성
                                            List<Event> remEv = compactCalendarView.getEvents(dateClicked);

                                            remEv.remove(0);
                                            textView_tmpList1.setText("Empty");
                                            Toast.makeText(getActivity(), "일정이 삭제되었습니다.", Toast.LENGTH_SHORT).show();

                                        }
                                    })
                                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            // 취소 클릭 시 실행할 거 작성
                                            Toast.makeText(getActivity(), "일정삭제가 취소되었습니다..", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .create();
                            dialog.show();
                        }
                    }
                });

                textView_tmpList2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(textView_tmpList2.getText().toString().equals("Empty")){
                            Toast.makeText(getActivity(), "삭제할 일정이 없습니다.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            AlertDialog dialog = builder.setTitle("일정을 삭제하겠습니까?")
                                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            // 확인 클릭 시 실행할 거 작성
                                            List<Event> remEv = compactCalendarView.getEvents(dateClicked);

                                            remEv.remove(1);
                                            textView_tmpList2.setText("Empty");
                                            Toast.makeText(getActivity(), "일정이 삭제되었습니다.", Toast.LENGTH_SHORT).show();

                                        }
                                    })
                                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            // 취소 클릭 시 실행할 거 작성
                                            Toast.makeText(getActivity(), "일정삭제가 취소되었습니다..", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .setNeutralButton("그냥 삭제", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            // 확인 클릭 시 실행할 거 작성
                                            List<Event> remEv = compactCalendarView.getEvents(dateClicked);

                                            remEv.remove(1);
                                            textView_tmpList2.setText("Empty");
                                            Toast.makeText(getActivity(), "일정이 삭제되었습니다.", Toast.LENGTH_SHORT).show();

                                        }
                                    })
                                    .create();
                            dialog.show();
                        }
                    }
                });

                textView_tmpList3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(textView_tmpList3.getText().toString().equals("Empty")){
                            Toast.makeText(getActivity(), "삭제할 일정이 없습니다.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            AlertDialog dialog = builder.setTitle("일정을 삭제하겠습니까?")
                                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            // 확인 클릭 시 실행할 거 작성
                                            List<Event> remEv = compactCalendarView.getEvents(dateClicked);

                                            remEv.remove(2);
                                            textView_tmpList3.setText("Empty");
                                            Toast.makeText(getActivity(), "일정이 삭제되었습니다.", Toast.LENGTH_SHORT).show();

                                        }
                                    })
                                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            // 취소 클릭 시 실행할 거 작성
                                            Toast.makeText(getActivity(), "일정삭제가 취소되었습니다..", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .create();
                            dialog.show();
                        }
                    }
                });

                    textView_result.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
                            String clickDate = simpleDate.format(dateClicked);

                            //Event 숫자 호출과 판정
                            List<Event> cntEvents = compactCalendarView.getEvents(dateClicked);

                            if (cntEvents.size() == 3) {
                                Toast.makeText(getActivity(), "일정이 꽉 찼습니다", Toast.LENGTH_SHORT).show();
                            }
                            else{
                            EditText editText = new EditText(getActivity());

                            // 일정입력할 팝업 띄우기
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            AlertDialog dialogText = builder.setTitle("추가할 일정을 입력해 주세요.")
                                    // .setMessage("메시지 입력")
                                    .setView(editText)
                                    .setPositiveButton("저장하기", new DialogInterface.OnClickListener() {
                                        @SuppressLint("SetTextI18n")
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String dateClicked_st = simpleDate.format(dateClicked);

                                            Date currentDay = null;
                                            try {
                                                // .parse 함수 : Parses text from a string to produce a Date (문자열에서 텍스트를 분석하여 날짜 생성)
                                                currentDay = simpleDate.parse(dateClicked_st);

                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }
                                            long currentLong = currentDay.getTime();

                                            Event ev1 = new Event(Color.GREEN, currentLong, editText.getText().toString());
                                            compactCalendarView.addEvent(ev1);
                                            toDoListDataBase.toDoDao().insert(new ToDoList(editText.getText().toString(), new Date(currentLong)));
                                            //Event 숫자 호출과 판정
                                            List<Event> cntEvents = compactCalendarView.getEvents(dateClicked);

                                            if (cntEvents.size() == 1) {

                                            if (cntEvents.size() == 0) {
                                                textView_tmpList1.setText(editText.getText().toString());
                                            }
                                            else if (cntEvents.size() == 2) {
                                                textView_tmpList2.setText(editText.getText().toString());
                                            }
                                            else if (cntEvents.size() == 3) {
                                                textView_tmpList3.setText(editText.getText().toString());
                                            }
                                            else {
                                                Toast.makeText(getActivity(), "일정이 꽉 찼습니다", Toast.LENGTH_SHORT).show();
                                                return;
                                            } else{
                                                textView_tmpList3.setText(editText.getText().toString());
                                            }

                                            Toast.makeText(getActivity(), "일정이 저장되었습니다.", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            // 취소 클릭 시 실행할 거 작성
                                            Toast.makeText(getActivity(), "일정입력 취소되었습니다.", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .create();
                            dialogText.show();
                            }
                        }
                    });
                }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                textView_month.setText(dateFormatForMonth.format(firstDayOfNewMonth));

            }
        });


    }
}

