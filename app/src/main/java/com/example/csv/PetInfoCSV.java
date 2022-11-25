package com.example.csv;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.csv.factor.PetInfoCsvFactor;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetInfoCSV {
    public List<PetInfoCsvFactor> getPetInfo(Context context) throws IOException, CsvException {
        AssetManager assets =context.getAssets();
        CsvReaderHelper a = new CsvReaderHelper(assets.open("csv/pet_info/pet_info.csv"));
        List<String[]> b = a.getData();
        List< PetInfoCsvFactor> res = new ArrayList<>();
        for(int i = 1; i<b.size();i++){
            String[] temp = b.get(i);
            res.add(new PetInfoCsvFactor(temp));
        }
        return res;

    }
}
