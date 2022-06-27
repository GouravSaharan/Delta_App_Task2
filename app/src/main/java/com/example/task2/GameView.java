package com.example.task2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    GameThread gameThread;


    public GameView(Context context) {
        super(context);

        init();

    }



    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

        if(!gameThread.isRunning()){
            gameThread=new GameThread(surfaceHolder);
            gameThread.start();
        }
        else
            gameThread.start();

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {



    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

        if(gameThread.isRunning()){
            gameThread.setisRunning(false);
            boolean retry=true;

            while(retry){
                try{
                    gameThread.join();
                    retry=false;

                }
                catch (Exception e){

                }
            }
        }

    }

    private void init() {
        SurfaceHolder holder=getHolder();
        holder.addCallback(this);
        setFocusable(true);
        gameThread=new GameThread(holder);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       int action=event.getAction();

       if(action==MotionEvent.ACTION_DOWN){
           AppConstants.getGameEngine().gameState=1;
           AppConstants.getGameEngine().ball.setVelocity(AppConstants.VELOCITY_WHEN_JUMP);

       }
       return true;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);


    }
}
