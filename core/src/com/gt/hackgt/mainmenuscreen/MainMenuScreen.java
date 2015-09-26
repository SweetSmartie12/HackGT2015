package com.gt.hackgt.mainmenuscreen;

import com.badlogic.gdx.Gdx;
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
    public void checkKeys() {
        if (Gdx.input.isKeyPressed(Input.Keys.C)) {
            game.switchScreen(HackGT.MAIN_MENU_SCREEN_NUMBER);
            dispose();
        }
    }
}
