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

        PetInfoCSV petInfoCSV = new PetInfoCSV();
        List<PetInfoCsvFactor> petInfo = petInfoCSV.getPetInfo(appContext);
        for(PetInfoCsvFactor i : petInfo){
            Log.v("asdf", i.name);
        }
        AchievementCSV achievementCSV = new AchievementCSV();
        List<AchievementCsvFactor> achievement = achievementCSV.getAchievement(appContext);
        for(AchievementCsvFactor i : achievement){
            Log.v("asdf", i.name);
        }

        ShopInfoCSV shop = new ShopInfoCSV();
        List<ShopCsvFactor> shopCSV = shop.getShopCSV(appContext);
        for(ShopCsvFactor o: shopCSV){
            Log.v("asdf", o.name);
        }
    }

}
