package com.example.cosmicslash;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Hud {

    private int score = 0;
    private int lives = 3;

    private Paint paintScore = new Paint();
    private Paint paintLives = new Paint();

    public Hud() {
        paintScore.setColor(Color.WHITE);
        paintScore.setTextSize(60);

        paintLives.setColor(Color.RED);
        paintLives.setTextSize(60);
    }

    public void addScore(int value) {
        score += value;
    }

    public void loseLife() {
        lives--;
        if (lives <= 0)
            gameOver();
    }

    public void activateMultiplier() {
        score += 100; // simples bônus extra
    }

    public void draw(Canvas c) {
        c.drawText("Score: " + score, 50, 80, paintScore);
        c.drawText("Vidas: " + lives, 50, 160, paintLives);
    }

    public void gameOver() {
        throw new RuntimeException("GAME_OVER");
    }
}