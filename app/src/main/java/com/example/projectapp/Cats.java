package com.example.projectapp;

public class Cats {

    //gör som dom visar på lenasys, vne om ja behöver det här
    private String race;
    private String color;
    private int size;


    public Cats(String inRace, String inColor, int inSize){
        race=inRace;
        color=inColor;
        size=inSize;
    }

    public Cats(String inRace){
        race=inRace;
        color="";
        size=-1;
    }

    public String toString(){return race;}

    public String info(){
        String str=race;
        str+=" is the race.";
        str+=color;
        str+="is the color.";
        str+=Integer.toString(size);
        str+="s.";
        return str;
    }

    public void setSize(int newSize){
        size=newSize;
    }


    public String getRace(){
        return race;
    }
    public String getColor(){
        return color;
    }

    public int getSize(){
        return size;
    }
}
