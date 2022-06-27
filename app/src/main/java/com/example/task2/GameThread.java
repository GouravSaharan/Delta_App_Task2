package com.example.task2;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.SurfaceHolder;

public class GameThread extends Thread{

    SurfaceHolder surfaceHolder;
    boolean isRunning;
    long startTime,loopTime,delay=30;


    public GameThread(SurfaceHolder surfaceHolder){

        this.surfaceHolder=surfaceHolder;
        isRunning=true;
    }

    @Override
    public void run() {
         while(isRunning){
             startTime= SystemClock.uptimeMillis();

             Canvas canvas=surfaceHolder.lockCanvas(null);

             if(canvas !=null){
                 synchronized (surfaceHolder){
                     AppConstants.getGameEngine().updateAndDrawBackgroundImage(canvas);
                     AppConstants.getGameEngine().updateAndDrawBall(canvas);


                     surfaceHolder.unlockCanvasAndPost(canvas);
                 }
             }

             loopTime=SystemClock.uptimeMillis()-startTime;

             if(loopTime<delay){
                 try{
                     Thread.sleep(delay-loopTime);
                 }
                 catch (Exception e){

                 }
             }
         }
    }

    public boolean isRunning(){
        return isRunning;
    }
    public void setisRunning(boolean state){
        isRunning=state;
    }
}
