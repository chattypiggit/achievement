package com.example.myapplication;



import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;

import com.example.csv.AchievementCSV;
import com.example.csv.PetInfoCSV;
import com.example.csv.ShopInfoCSV;
import com.example.csv.factor.AchievementCsvFactor;
import com.example.csv.factor.PetInfoCsvFactor;
import com.example.csv.factor.ShopCsvFactor;
import com.opencsv.exceptions.CsvException;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class AchievementTest { //csv 파일 읽기
    @Test
    public void useAppContext() throws IOException, CsvException {
        // Context of the app under test.

        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AssetManager assets =appContext.getAssets();
        PetInfoCSV a = new PetInfoCSV();
        List<PetInfoCsvFactor> b = a.getPetInfo(appContext);
        for(PetInfoCsvFactor i : b){
            Log.v("asdf", i.flavor_text);
        }
        AchievementCSV asdf = new AchievementCSV();
        List<AchievementCsvFactor> asd = asdf.getAchievement(appContext);
        for(AchievementCsvFactor i : asd){
            Log.v("asdf", i.name);
        }

        ShopInfoCSV shop = new ShopInfoCSV();
        List<ShopCsvFactor> t = shop.getShopCSV(appContext);
        for(ShopCsvFactor o: t){
            Log.v("asdf", o.name);
        }
    }

}
