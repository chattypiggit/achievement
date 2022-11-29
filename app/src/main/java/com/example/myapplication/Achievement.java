package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.csv.AchievementCSV;
import com.example.csv.factor.AchievementCsvFactor;
import com.example.myapplication.helper.AchievementHelper;

import java.util.List;


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
        return view;
    }
    @Override
    public void onResume() {
        Context context = getContext();

        AchievementHelper helper = new AchievementHelper(context);
        super.onResume();
        List<AchievementCsvFactor> achievementCsvFactors;
        try{
            assert context != null;
            achievementCsvFactors = (new AchievementCSV()).getAchievement(context);
            for(AchievementCsvFactor achievement :achievementCsvFactors ){
                if(!helper.isAcquired(achievement.idx)){

                }

            }
        }
        catch(Exception e){

        }

    }

}