package com.example.myapplication;



import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;

import com.example.csv.AchievementCSV;
import com.example.csv.PetInfoCSV;
import com.example.csv.factor.AchievementCSVFactor;
import com.example.csv.factor.PetInfoCsvFactor;
import com.opencsv.exceptions.CsvException;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class AchievementTest {
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
        List<AchievementCSVFactor> asd = asdf.getAchievement(appContext);
        for(AchievementCSVFactor i : asd){
            Log.v("asdf", i.name);
        }
    }

}
