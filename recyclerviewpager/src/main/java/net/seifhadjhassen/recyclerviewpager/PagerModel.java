package net.seifhadjhassen.recyclerviewpager;

import android.content.Context;

public class PagerModel {

    String img;
    String title;
    Context context;

    public PagerModel(Context context){
        this.context=context;
    }



    public PagerModel(int img, String title,Context context) {
        this.img = "android.resource://"+context.getPackageName()+"/drawable/"+img;
        this.title = title;
    }
    public PagerModel(String img, String title) {
        this.img = img;
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = "android.resource://"+context.getPackageName()+"/drawable/"+img;
    }
    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
