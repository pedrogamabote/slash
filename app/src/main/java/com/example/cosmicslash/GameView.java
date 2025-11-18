package com.example.cosmicslash;

import android.content.Context;
import android.graphics.*;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class GameView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isRunning = false;

    private Bitmap fundo;
    private Paint paint = new Paint();
    private Hud hud;
    private Spawner spawner;

    private ArrayList<GameObject> objetos = new ArrayList<>();
    private ArrayList<SlashEffect> slashes = new ArrayList<>();

    private float lastX, lastY;

    public GameView(Context ctx) {
        super(ctx);

        fundo = BitmapFactory.decodeResource(getResources(), R.drawable.fundo_1);

        hud = new Hud();
        spawner = new Spawner(ctx, objetos);

        // Spawn inicial
        for (int i = 0; i < 3; i++)
            spawner.spawnRandom();
    }

    @Override
    public void run() {
        while (isRunning) {
            update();
            draw();
        }
    }

    private void update() {
        spawner.update();

        for (GameObject obj : objetos)
            obj.update();

        for (SlashEffect s : slashes)
            s.update();

        detectCuts();
    }

    private void detectCuts() {
        for (GameObject obj : objetos) {
            for (SlashEffect s : slashes) {
                if (obj.hitBy(s.x, s.y)) {
                    obj.onCut(hud);
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();

        if (e.getAction() == MotionEvent.ACTION_MOVE) {
            slashes.add(new SlashEffect(x, y));
            lastX = x;
            lastY = y;
        }

        return true;
    }

    private void draw() {
        SurfaceHolder holder = getHolder();
        if (!holder.getSurface().isValid()) return;

        Canvas c = holder.lockCanvas();

        c.drawBitmap(fundo, 0, 0, null);

        for (GameObject obj : objetos)
            obj.draw(c, paint);

        for (SlashEffect s : slashes)
            s.draw(c);

        hud.draw(c);

        holder.unlockCanvasAndPost(c);
    }

    public void resume() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        isRunning = false;
        try { thread.join(); } catch (Exception e) {}
    }
}
