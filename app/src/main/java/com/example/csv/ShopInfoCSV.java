package com.example.csv;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.csv.factor.PetInfoCsvFactor;
import com.example.csv.factor.ShopCsvFactor;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopInfoCSV {
    public List<ShopCsvFactor> getShopCSV(Context context) throws IOException, CsvException {
        AssetManager assets =context.getAssets();
        CsvReaderHelper a = new CsvReaderHelper(assets.open("csv/shop/shop.csv"));
        List<String[]> b = a.getData();
        List< ShopCsvFactor> res = new ArrayList<>();
        for(int i = 1; i<b.size();i++){
            String[] temp = b.get(i);
            res.add(new ShopCsvFactor(temp));
        }
        return res;

    }
}
