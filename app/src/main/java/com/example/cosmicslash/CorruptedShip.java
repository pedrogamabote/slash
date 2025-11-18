package com.example.cosmicslash;

import android.content.Context;

public class CorruptedShip extends GameObject {

    public CorruptedShip(Context c) {
        super(c, R.drawable.nave_corrompida);
    }

    @Override
    public void update() {
        super.update();
        x += Math.sin(y * 0.05) * 10;
    }

    @Override
    public void onCut(Hud hud) {
        hud.addScore(30);
        reset();
    }
}
