package com.example.task2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.SurfaceView;

public class GameEngine    {

    BackgroundImage backgroundImage;
    Ball ball;


    Point point;
    static int gameState;


    public GameEngine(){
        backgroundImage=new BackgroundImage();
        ball=new Ball();
        gameState=0;

        point=new Point(150,150);





    }

    public void  updateAndDrawBackgroundImage(Canvas canvas){

        backgroundImage.setBgIX(backgroundImage.getBgIX()-backgroundImage.getBgIVelocite());

        if(backgroundImage.getBgIX()<-AppConstants.getBitmapImage().getBackgroundWidth()){
            backgroundImage.setBgIX(0);
        }
        canvas.drawBitmap(AppConstants.getBitmapImage().background, backgroundImage.getBgIX(),backgroundImage.getBgIY(),null);

        if(backgroundImage.getBgIX()< -(AppConstants.getBitmapImage().getBackgroundWidth()-AppConstants.SCREEN_WIDTH)){
            canvas.drawBitmap(AppConstants.getBitmapImage().background, backgroundImage.getBgIX()+AppConstants.getBitmapImage().getBackgroundWidth()
            ,backgroundImage.getBgIY(),null);
        }
    }

    public void updateAndDrawBall(Canvas canvas){

        if(gameState==1){

        if(ball.getY() < (AppConstants.SCREEN_HEIGHT-AppConstants.getBitmapImage().getBallHeight()) ||ball.getVelocity()<0){
            ball.setVelocity(ball.getVelocity()+AppConstants.gravity);
            ball.setY(ball.getY()+ball.getVelocity());
        }

        }
        int currentFrame= ball.currentFrame;
        canvas.drawBitmap(AppConstants.getBitmapImage().getBall(currentFrame),ball.getX(),ball.getY(),null);

        if(currentFrame> ball.maxFrame){
            currentFrame=0;
        }
        ball.setCurrentFrame(currentFrame);
    }



}
