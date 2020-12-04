package com.example.myapplication10.constant;

import com.example.myapplication10.R;

import java.util.ArrayList;

public class ImageList {
    public static ArrayList<Integer> getDefault() {
        ArrayList<Integer> imageList = new ArrayList<Integer>();
        imageList.add(R.drawable.banner1);
        imageList.add(R.drawable.banner2);
        imageList.add(R.drawable.banner3);
        imageList.add(R.drawable.banner4);
        imageList.add(R.drawable.banner5);
        return imageList;
    }
}
