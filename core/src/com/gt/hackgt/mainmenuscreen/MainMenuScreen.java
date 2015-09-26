package com.gt.hackgt.mainmenuscreen;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.gt.hackgt.HackGT;
import com.gt.hackgt.utils.BasicScreen;

/**
 * Main menu of the game that will control navigation to the rest of the screens.
 */
public class MainMenuScreen extends BasicScreen {
    private Texture background;

    public MainMenuScreen(HackGT game) {
        super(game);
        background = new Texture("mainmenuscreen/MainMenuBackground.png");
    }

    @Override
    public void dispose() {

    }

    @Override
    public void draw(float delta) {
        game.batch.draw(background, 0, 0, HackGT.CAMERA_WIDTH, HackGT.CAMERA_HEIGHT);
    }

    @Override
    public void updateObjects() {

    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.C) {
            game.switchScreen(HackGT.MAIN_MENU_SCREEN_NUMBER);
            dispose();
            return true;
        } else if (keycode == Input.Keys.SPACE) {
            game.switchScreen(HackGT.LEVEL_SCREEN_NUMBER);
            dispose();
            return true;
        }
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
