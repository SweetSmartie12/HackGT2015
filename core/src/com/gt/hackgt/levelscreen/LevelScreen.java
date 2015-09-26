package com.gt.hackgt.levelscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.gt.hackgt.HackGT;
import com.gt.hackgt.gameobject.GameObject;
import com.gt.hackgt.utils.BasicScreen;

/**
 * Represents a singular level in the game.
 */
public class LevelScreen extends BasicScreen {

    private Stage stage;
    private GameObject playerObject;

    public LevelScreen(HackGT game) {
        super(game);
        stage = new Stage(new ScreenViewport(game.camera));
        playerObject = new GameObject();
        playerObject.setTexture(new Texture("badlogic.jpg"));
        playerObject.setSize(64, 48);
        stage.addActor(playerObject);
        Gdx.input.setInputProcessor(this);
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
    public boolean keyDown(int keycode) {

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
