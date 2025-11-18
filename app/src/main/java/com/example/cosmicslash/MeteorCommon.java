package com.example.cosmicslash;

import android.content.Context;

public class MeteorCommon extends GameObject {

    public MeteorCommon(Context c) {
        super(c, R.drawable.meteoro_comum);
    }

    @Override
    public void onCut(Hud hud) {
        hud.addScore(10);
        reset();
    }
}
