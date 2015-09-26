package com.gt.hackgt.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.gt.hackgt.HackGT;

/**
 * A basic screen all of the other screens should be based on.
 */
public abstract class BasicScreen implements Screen, InputProcessor {

    protected HackGT game;

    public BasicScreen(HackGT game) {
        this.game = game;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // Clears the screen.
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Sets the camera, and begins drawing.
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();

        draw(delta);

        // End the drawing.
        game.batch.end();

        updateObjects();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    public abstract void dispose();

    /**
     * Used to draw the various things on the screen.
     * @param delta
     */
    public abstract void draw(float delta);

    /**
     * Called every frame to update the objects in the current screen.
     */
    public abstract void updateObjects();
}
