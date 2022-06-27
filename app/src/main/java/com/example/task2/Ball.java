package com.example.task2;

public class Ball {

    public int ballX,ballY,currentFrame,velocity;
    public static int maxFrame;

    public  Ball(){
        ballX=AppConstants.SCREEN_WIDTH/2-AppConstants.getBitmapImage().getBallWidth()/2;
        ballY=AppConstants.SCREEN_HEIGHT/2-AppConstants.getBitmapImage().getBallHeight()/2;
        currentFrame=0;
        maxFrame=1;
        velocity=0;
    }

    public int getVelocity(){
        return velocity;
    }

    public void setVelocity(int velocity){
        this.velocity=velocity;
    }
    public int currentFrame(){
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame){
        this.currentFrame=currentFrame;
    }

    public int getX(){
        return ballX;
    }
    public int getY(){
        return  ballY;
    }
    public  void setX(int ballX){
        this.ballX=ballX;
    }
    public void setY(int ballY){
        this.ballY=ballY;
    }
}
