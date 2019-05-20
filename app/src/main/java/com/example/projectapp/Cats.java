package com.example.projectapp;

public class Cats {

    //gör som dom visar på lenasys, vne om ja behöver det här
    private String race;
    private String color;
    private String size;
    private String catImg;


    public Cats(String inRace, String inColor, String inSize, String inImg){
        race=inRace;
        color=inColor;
        size=inSize;
        catImg=inImg;
    }

    public Cats(String inRace){
        race=inRace;
        color="";
        size="";
        catImg="";
    }

    public String toString(){return race;}

    public String info(){
        String str=race;
        str+=" is the race.";
        str+=color;
        str+="is the color.";
        str+=size;
        str+="is the size";
        str+=catImg;
        str+="is the image";
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
    public String getCatImg(){return catImg;}


}
