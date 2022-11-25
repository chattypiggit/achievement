package com.example.csv.factor;

public class PetInfoCsvFactor {
    public int idx = -1;
    public String name = "";
    public int progress = -1;
    public int max_exp = -1;
    public int next_idx = -1;
    public String flavor_text = "";
    public String img_dir = "";

    public PetInfoCsvFactor(String[] temp){

        if(temp[0] !=null){
            idx =  Integer.parseInt(temp[0]);
        }
        name =  temp[1];

        if(temp[2] !=null && !temp[2].equals("")){
            progress =  Integer.parseInt(temp[2]);
        }

        if(temp[3] !=null && !temp[3].equals("")){
            max_exp =  Integer.parseInt(temp[3]);
        }
        if(temp[4] !=null && !temp[4].equals("")){
            next_idx =  Integer.parseInt(temp[4]);
        }
        if(temp[5] != null){
            flavor_text = temp[5];
        }
        if(temp[6] !=null){
            img_dir =  temp[6];
        }

    }
}
