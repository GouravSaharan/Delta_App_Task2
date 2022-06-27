package com.example.task2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapImage {

    Bitmap background;
    Bitmap[] ball;

    public BitmapImage(Resources resources) {

        background= BitmapFactory.decodeResource(resources,R.drawable.gamebackground);
        background=scaleImage(background);
        ball=new Bitmap[2];
        ball[0]=BitmapFactory.decodeResource(resources,R.drawable.ball);
        ball[1]=BitmapFactory.decodeResource(resources,R.drawable.ball);
    }

    public Bitmap getBall(int frame){
        return  ball[frame];
    }

    public int getBallWidth(){
        return  ball[0].getWidth();
    }

    public int getBallHeight(){
        return ball[0].getHeight();
    }

    public Bitmap getBackground(){
        return  background;
    }

    public int getBackgroundWidth(){
        return  background.getWidth();
    }

    public  int getBackgroundheight(){
        return background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){

        float widthHeightRatio=getBackgroundWidth()/getBackgroundheight();

        int backGroundScaleWidth= (int)widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap,backGroundScaleWidth,AppConstants.SCREEN_HEIGHT,false);

    }
}
