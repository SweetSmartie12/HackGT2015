package com.gt.hackgt.splashscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.gt.hackgt.HackGT;
import com.gt.hackgt.utils.BasicScreen;

/**
 * Basic Splash/Title screen for the game itself.
 */
public class SplashScreen extends BasicScreen {
    private Texture background;

    public SplashScreen(HackGT game) {
        super(game);
        background = new Texture("splashscreen/TitleBackground.png");
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
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            game.switchScreen(HackGT.MAIN_MENU_SCREEN_NUMBER);
            dispose();
        }
    }

    @Override
    public void dispose() {
        background.dispose();
    }
}
