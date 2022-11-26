package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class PetBook extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pbook, container, false);

        view.findViewById(R.id.petImage_1_1).setOnClickListener(this);
        view.findViewById(R.id.petImage_1_2).setOnClickListener(this);
        view.findViewById(R.id.petImage_1_3).setOnClickListener(this);
        view.findViewById(R.id.petImage_2_1).setOnClickListener(this);
        view.findViewById(R.id.petImage_2_2).setOnClickListener(this);
        view.findViewById(R.id.petImage_2_3).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.petImage_1_1: bundle.putInt("INDEX", 1); break;

            case R.id.petImage_1_2: bundle.putInt("INDEX", 2); break;

            case R.id.petImage_1_3: bundle.putInt("INDEX", 3); break;

            case R.id.petImage_2_1: bundle.putInt("INDEX", 4); break;

            case R.id.petImage_2_2: bundle.putInt("INDEX", 5); break;

            case R.id.petImage_2_3: bundle.putInt("INDEX", 6); break;
        }

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        PetInfo petInfo = new PetInfo();
        petInfo.setArguments(bundle);
        transaction.replace(R.id.home_ly, petInfo);
        transaction.commit();
    }
}