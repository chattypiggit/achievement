package com.example.myapplication;

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

public class PetInfo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pinfo, container, false);

        if(getArguments()!=null) {
            ImageView petImage = view.findViewById(R.id.petImage);
            TextView petName = view.findViewById(R.id.petName);
            TextView petInfo = view.findViewById(R.id.petInfo);
            int petImageId;
            int petNameId;
            int petInfoId;

            int index = getArguments().getInt("INDEX", 1);
            switch (index) {
                case 1:
                    petImageId = R.drawable.pet_1_1;
                    petNameId= R.string.petName_1_1;
                    petInfoId = R.string.petInfo_1_1;
                    break;

                case 2:
                    petImageId = R.drawable.pet_1_2;
                    petNameId= R.string.petName_1_2;
                    petInfoId = R.string.petInfo_1_2;
                    break;

                case 3:
                    petImageId = R.drawable.pet_1_3;
                    petNameId= R.string.petName_1_3;
                    petInfoId = R.string.petInfo_1_3;
                    break;

                case 4:
                    petImageId = R.drawable.pet_2_1;
                    petNameId= R.string.petName_2_1;
                    petInfoId = R.string.petInfo_2_1;
                    break;

                case 5:
                    petImageId = R.drawable.pet_2_2;
                    petNameId= R.string.petName_2_2;
                    petInfoId = R.string.petInfo_2_2;
                    break;

                case 6:
                    petImageId = R.drawable.pet_2_3;
                    petNameId= R.string.petName_2_3;
                    petInfoId = R.string.petInfo_2_3;
                    break;

                default:
                    petImageId = 0;
                    petNameId= 0;
                    petInfoId = 0;
            }

            petImage.setImageResource(petImageId);
            petName.setText(petNameId);
            petInfo.setText(petInfoId);
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

        return view;
    }
}
