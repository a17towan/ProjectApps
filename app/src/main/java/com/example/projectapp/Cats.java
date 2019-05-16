package com.example.projectapp;

public class Cats {

    //gör som dom visar på lenasys, vne om ja behöver det här
    private String race;
    private String color;
    private String size;


    public Cats(String inRace, String inColor, String inSize){
        race=inRace;
        color=inColor;
        size=inSize;
    }

    public Cats(String inRace){
        race=inRace;
        color="";
        size="";
    }

    public String toString(){return race;}

    public String info(){
        String str=race;
        str+=" is the race.";
        str+=color;
        str+="is the color.";
        str+=size;
        str+="is the size";
        return str;
    }

    public void setSize(String newSize){
        size=newSize;
    }


    public String getRace(){
        return race;
    }
    public String getColor(){
        return color;
    }

    public String getSize(){
        return size;
    }
}
