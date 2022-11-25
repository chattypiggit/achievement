package com.example.csv.factor;

public class ShopCsvFactor {
    public int idx = -1;
    public int cost =-1;
    public String name ="";
    public String flavor_text ="";
    public String img_path ="";

    public ShopCsvFactor(String[] temp) {
        if (temp[0] != null) {
            idx = Integer.parseInt(temp[0]);
        }
        if (temp[1] != null && !"".equals(temp[1])) {
            cost = Integer.parseInt(temp[1]);
        }
        name = temp[2];
        flavor_text = temp[3];
        img_path = temp[4];
    }
}
