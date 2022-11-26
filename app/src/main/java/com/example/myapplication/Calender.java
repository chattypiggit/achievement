package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

    private SimpleDateFormat dateFormatForDisplaying = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
    private SimpleDateFormat dateFormatForMonth = new SimpleDateFormat("yyyy년 MM월", Locale.KOREA);
    private SimpleDateFormat dateFormatForMonth2 = new SimpleDateFormat("yyyy-MM", Locale.KOREA);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
        textView_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getDate = textView_tmpList1.getText().toString();

                String[] getDate2 = getDate.split(":");
                String getDateST = getDate2[0];

                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                AlertDialog dialog = builder.setTitle("어느 일정을 완료하셨나요?")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 확인 클릭 시 실행할 거 작성
                                Date writeDate = null;
                                try {
                                    writeDate = simpleDate.parse(getDateST);

                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                Long currentLong = writeDate.getTime();

                                compactCalendarView.removeEvents(currentLong);
                                textView_tmpList3.setText("");
                                Toast.makeText(getActivity(), "일정이 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("중간", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 중간위치 일정 완료
                                Date writeDate = null;
                                try {
                                    writeDate = simpleDate.parse(getDateST);

                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                Long currentLong = writeDate.getTime();

                                compactCalendarView.removeEvents(currentLong);
                                textView_tmpList2.setText("");
                                Toast.makeText(getActivity(), "일정이 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                dialog.show();
            }
        });

        // 날짜 클릭 이벤트 관련 코드
        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                List<Event> events = compactCalendarView.getEvents(dateClicked);

                // 해당날짜에 이벤트가 있으면
                if (events.size() > 0) {
                    textView_tmpList1.setText(events.get(0).getData().toString());
                }
                // 해당날짜에 이벤트가 없으면
                else {
                    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
                    String clickDate = simpleDate.format(dateClicked);

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
                                    Long currentLong = currentDay.getTime();

                                    Event ev1 = new Event(Color.GREEN, currentLong, clickDate + " : "+ editText.getText().toString());
                                    compactCalendarView.addEvent(ev1);
                                    textView_tmpList1.setText(clickDate + " : "+ editText.getText().toString());
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

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                textView_month.setText(dateFormatForMonth.format(firstDayOfNewMonth));

            }
        });
    }
}

