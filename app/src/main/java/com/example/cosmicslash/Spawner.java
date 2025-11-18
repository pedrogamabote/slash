package com.example.cosmicslash;

import android.content.Context;
import java.util.ArrayList;

public class Spawner {

    private Context ctx;
    private ArrayList<GameObject> list;

    private int timer = 0;

    public Spawner(Context c, ArrayList<GameObject> list) {
        this.ctx = c;
        this.list = list;
    }

    public void update() {
        timer++;

        if (timer % 50 == 0)
            spawnRandom();
    }

    public void spawnRandom() {
        int r = (int)(Math.random()*10);

        if (r <= 4)
            list.add(new MeteorCommon(ctx));
        else if (r <= 6)
            list.add(new MeteorPlasma(ctx));
        else if (r <= 8)
            list.add(new CorruptedShip(ctx));
        else if (r == 9)
            list.add(new CosmicCrystal(ctx));
        else
            list.add(new BlackHole(ctx));
    }
}
