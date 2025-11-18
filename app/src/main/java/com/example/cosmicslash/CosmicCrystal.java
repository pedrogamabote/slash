package com.example.cosmicslash;

import android.content.Context;

public class CosmicCrystal extends GameObject {

    public CosmicCrystal(Context c) {
        super(c, R.drawable.cristal);
    }

    @Override
    public void onCut(Hud hud) {
        hud.addScore(50);
        hud.activateMultiplier();
        reset();
    }
}