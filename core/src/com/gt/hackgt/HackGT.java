package com.gt.hackgt;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gt.hackgt.codescreen.CodeScreen;
import com.gt.hackgt.levelscreen.LevelScreen;
import com.gt.hackgt.mainmenuscreen.MainMenuScreen;
import com.gt.hackgt.splashscreen.SplashScreen;

public class HackGT extends Game {
    public final static int CAMERA_WIDTH = 640;
    public final static int CAMERA_HEIGHT = 480;

    public final static int SPLASH_SCREEN_NUMBER = 1;
    public final static int MAIN_MENU_SCREEN_NUMBER = 2;
    public final static int CODE_SCREEN_NUMBER = 3;
    public final static int LEVEL_SCREEN_NUMBER = 4;

    public SpriteBatch batch;
    public OrthographicCamera camera;
    public BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        font = new BitmapFont();
        font.setColor(0, 0, 0, 1);
        camera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
        this.setScreen(new SplashScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Used to switch between the various screens.
     * @param screen the screen number to switch to.
     */
    public void switchScreen(int screen) {
        switch (screen) {
            case HackGT.SPLASH_SCREEN_NUMBER:
                setScreen(new SplashScreen(this));
                break;

            case HackGT.MAIN_MENU_SCREEN_NUMBER:
                setScreen(new MainMenuScreen(this));
                break;

            case HackGT.CODE_SCREEN_NUMBER:
                setScreen(new CodeScreen(this));
                break;

            case HackGT.LEVEL_SCREEN_NUMBER:
                setScreen(new LevelScreen(this));
                break;
        }
    }
}
