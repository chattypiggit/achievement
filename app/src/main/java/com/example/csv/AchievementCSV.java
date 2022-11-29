package com.example.csv;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.example.csv.factor.AchievementCsvFactor;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AchievementCSV {
    public List<AchievementCsvFactor> getAchievement(Context context) throws IOException, CsvException {
        AssetManager assets = context.getAssets();
        CsvReaderHelper a = new CsvReaderHelper(assets.open("csv/achievement/achievement.csv"));
        List<String[]> b = a.getData();
        List<AchievementCsvFactor> res = new ArrayList<>();
        for (int i = 1; i < b.size(); i++) {
            String[] temp = b.get(i);
            res.add(new AchievementCsvFactor(temp));
        }
        return res;
    }
}
