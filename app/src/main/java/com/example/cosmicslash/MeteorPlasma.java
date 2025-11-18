package com.example.cosmicslash;

import android.content.Context;

public class MeteorPlasma extends GameObject {

    public MeteorPlasma(Context c) {
        super(c, R.drawable.meteoro_plasma);
        speedY -= 5; // mais rápido
    }

    @Override
    public void onCut(Hud hud) {
        hud.addScore(20);
        reset();
    }
}
