package com.example.cosmicslash;

import android.content.Context;

public class BlackHole extends GameObject {

    public BlackHole(Context c) {
        super(c, R.drawable.buraco_negro);
        speedY = -4;
    }

    @Override
    public void onCut(Hud hud) {
        hud.gameOver();
    }
}
