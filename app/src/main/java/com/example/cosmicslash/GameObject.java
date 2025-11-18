package com.example.cosmicslash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class GameObject {

    protected float x;
    protected double y;
    protected double speedY;
    protected Bitmap image;
    protected Context ctx;

    public GameObject(Context c, int resId) {
        this.ctx = c;
        image = BitmapFactory.decodeResource(c.getResources(), resId);

        x = (float) (Math.random() * 700);
        y = 2200;

        speedY = - (5 + Math.random() * 8);
    }

    public void update() {
        y += speedY;

        if (y < -image.getHeight())
            reset();
    }

    public void draw(Canvas c, Paint p) {
        c.drawBitmap(image, x, (float) y, p);
    }

    public boolean hitBy(float tx, float ty) {
        return tx > x && tx < x + image.getWidth() &&
                ty > y && ty < y + image.getHeight();
    }

    protected void reset() {
        y = 2200;
        x = (float)(Math.random() * 700);
    }

    public abstract void onCut(Hud hud);
}