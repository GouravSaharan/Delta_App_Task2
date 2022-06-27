package com.example.task2;

public class BackgroundImage {

    private int bgIX,bgIY,bgIVelocite;

    public BackgroundImage(){
        bgIX=0;
        bgIY=0;
        bgIVelocite=6;
    }

    public int getBgIX() {
        return bgIX;
    }

    public void setBgIX(int bgIX) {
        this.bgIX = bgIX;
    }

    public int getBgIY() {
        return bgIY;
    }

    public void setBgIY(int bgIY) {
        this.bgIY = bgIY;
    }

    public int getBgIVelocite() {
        return bgIVelocite;
    }

    public void setBgIVelocite(int bgIVelocite) {
        this.bgIVelocite = bgIVelocite;
    }
}
