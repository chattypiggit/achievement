package com.example.csv.factor;

public class AchievementCsvFactor {
    public int idx = -1;
    public String name ="";
    public String flavor_text ="";
    public String img_path ="";

    public AchievementCsvFactor(String[] temp) {
        if (temp[0] != null) {
            idx = Integer.parseInt(temp[0]);
        }
        name = temp[1];
        flavor_text = temp[2];
        img_path = temp[3];
    }

}
