package com.example.csv;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.csv.factor.AchievementCSVFactor;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AchievementCSV {
    public List<AchievementCSVFactor> getAchievement(Context context) throws IOException, CsvException {
        AssetManager assets = context.getAssets();
        CsvReaderHelper a = new CsvReaderHelper(assets.open("csv/achievement/achievement.csv"));
        List<String[]> b = a.getData();
        List<AchievementCSVFactor> res = new ArrayList<>();
        for (int i = 1; i < b.size(); i++) {
            String[] temp = b.get(i);
            res.add(new AchievementCSVFactor(temp));
        }
        return res;
    }
}
