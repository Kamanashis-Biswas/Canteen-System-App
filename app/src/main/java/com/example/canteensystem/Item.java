package com.example.canteensystem;

public class Item {
    private  int mImage;
    private String text1;
    private String text2;

    public Item(int mImage, String text1, String text2){
        this.text1 = text1;
        this.mImage = mImage;
        this.text2 = text2;

    }

    public int getmImage() {
        return mImage;
    }

    public String getText1() {
        return text1;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText2() {
        return text2;
    }
}
