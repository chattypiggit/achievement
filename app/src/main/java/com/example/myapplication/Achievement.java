package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Achievement extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_achv, container, false);
       ((MainActivity)getActivity()).setActionBarTitle("업적");

        //변수에 의한 텍스트와 이미지 제어
        ImageView imageView = (ImageView) view.findViewById(R.id.ach_img1);
        TextView textView = (TextView) view.findViewById(R.id.ach_txt1);

        int status = 1;
        String testStr = "Test String";

        if (status == 1){
            imageView.setImageResource(R.drawable.test2);
            textView.setText(testStr);
        }


        return view;
    }

}