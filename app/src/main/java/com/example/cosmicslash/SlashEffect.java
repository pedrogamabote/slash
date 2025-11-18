package com.example.cosmicslash;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class SlashEffect {

    public float x, y;
    private int alpha = 255;

    public SlashEffect(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        alpha -= 15;
        if (alpha < 0) alpha = 0;
    }

    public void draw(Canvas c) {
        Paint p = new Paint();
        p.setColor(Color.CYAN);
        p.setAlpha(alpha);
        p.setStrokeWidth(20);
        c.drawCircle(x, y, 20, p);
    }
}
