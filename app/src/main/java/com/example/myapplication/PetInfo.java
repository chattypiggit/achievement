package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.csv.PetInfoCSV;
import com.example.csv.factor.PetInfoCsvFactor;

import java.util.List;
import java.util.Vector;
import java.util.prefs.Preferences;

public class PetInfo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pinfo, container, false);

        Context context = getContext();
        List<PetInfoCsvFactor> petInfoCsv;
        try{
            assert context != null;
            petInfoCsv = (new PetInfoCSV()).getPetInfo(context);
            if(getArguments()!=null) {
                ImageView petImage = view.findViewById(R.id.petImage);
                TextView petName = view.findViewById(R.id.petName);
                TextView petInfo = view.findViewById(R.id.petInfo);
                int index = getArguments().getInt("INDEX", 1)-1;
                PetInfoCsvFactor petInfoContainer = petInfoCsv.get(index);
                int petImageId = this.getResources().getIdentifier(petInfoContainer.img_dir, "drawable", context.getPackageName());
                petImage.setImageResource(petImageId);
                petName.setText(petInfoContainer.name);
                petInfo.setText(petInfoContainer.flavor_text.replace("<br>","\n"));
            }
        }
        catch(Exception e){

        }



        Button backBtn = view.findViewById(R.id.backButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                PetBook petBook = new PetBook();
                transaction.replace(R.id.home_ly, petBook);
                transaction.commit();
            }
        });

        Button chBtn = view.findViewById(R.id.button);
        chBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = getArguments().getInt("INDEX", 1)-1;
                Bundle bundle = new Bundle(); // 번들을 통해 값 전달
                bundle.putInt("value", index);//번들에 넘길 값 저장
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Calender fragment2 = new Calender();//프래그먼트2 선언
                fragment2.setArguments(bundle);//번들을 프래그먼트2로 보낼 준비
                transaction.replace(R.id.home_ly, fragment2);
                transaction.commit();
            }
        });

        return view;
    }
}
