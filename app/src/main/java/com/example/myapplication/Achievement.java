package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.csv.AchievementCSV;
import com.example.csv.factor.AchievementCsvFactor;
import com.example.myapplication.helper.AchievementHelper;

import org.w3c.dom.Text;

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
        super.onResume();
        Context context = getContext();

        AchievementHelper helper = new AchievementHelper(context);
        List<AchievementCsvFactor> achievementCsvFactors;
        try{
            assert context != null;
            achievementCsvFactors = (new AchievementCSV()).getAchievement(context);

            for(AchievementCsvFactor achievement :achievementCsvFactors ){
                String num = Integer.toString(achievement.idx+1);
                int imgID = getResources().getIdentifier("ach_img"+num, "id", context.getPackageName());
                if(!helper.isAcquired(achievement.idx)){
                    ImageView imageView = (ImageView) getView().findViewById(imgID);
                    imageView.setImageResource(R.drawable.petlev_max);
                }
                int resID = getResources().getIdentifier("ach_txt"+num, "id", context.getPackageName());
                TextView textView = (TextView) getView().findViewById(resID);
                textView.setText(achievement.name);
            }
        }
        catch(Exception e){
            Log.e("asdf", e.toString());
        }

    }

}