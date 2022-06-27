package com.example.task2;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;


public class AppConstants {

    static BitmapImage bitmapBank;
    static GameEngine gameEngine;
    static int SCREEN_WIDTH,SCREEN_HEIGHT;
    static  int gravity;
    static  int VELOCITY_WHEN_JUMP;

    public static void initialization(Context context){

        setScreenSize(context);
        bitmapBank=new BitmapImage(context.getResources());
        gameEngine=new GameEngine();
       AppConstants.gravity=3;
        AppConstants.VELOCITY_WHEN_JUMP=-40;

    }

    public static BitmapImage getBitmapImage(){
        return bitmapBank;
    }

    public static GameEngine getGameEngine(){
        return gameEngine;
    }

    public static  void setScreenSize(Context context){

        WindowManager windowManager=(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display=windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics=new DisplayMetrics();
        display.getMetrics(displayMetrics);
        int width=displayMetrics.widthPixels;
        int height=displayMetrics.heightPixels;
        AppConstants.SCREEN_WIDTH=width;
        AppConstants.SCREEN_HEIGHT=height;
    }

}
