package com.example.canteensystem;

public class LItem {
    private int mimageresouce;
    private String mtext1;
    private String mtext2;
    public LItem(int img, String txt1, String txt2){
        mimageresouce = img;
        mtext1 = txt1;
        mtext2 = txt2;

    }

    public int getMimageresouce() {
        return mimageresouce;
    }

    public String getMtext1() {
        return mtext1;
    }

    public String getMtext2() {
        return mtext2;
    }
}
