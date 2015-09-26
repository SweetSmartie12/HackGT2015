package com.gt.hackgt.levelscreen;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.gt.hackgt.HackGT;
import com.gt.hackgt.utils.BasicScreen;

/**
 * Represents a singular level in the game.
 */
public class LevelScreen extends BasicScreen {

    private LevelManager levelManager;
    private Stage stage;

    public LevelScreen(HackGT game) {
        super(game);
        levelManager = new LevelManager();
        stage = new Stage(new ScreenViewport(game.camera));
    }

    @Override
    public void dispose() {

    }

    @Override
    public void draw(float delta) {
        stage.draw();
    }

    @Override
    public void updateObjects() {
        stage.act();
    }

    @Override
    public void checkKeys() {

    }
}
