package com.gt.hackgt.codescreen;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.gt.hackgt.HackGT;
import com.gt.hackgt.codeinterpreter.UIBlock;
import com.gt.hackgt.utils.BasicScreen;

import java.util.ArrayList;

/**
 * Created by Lauren on 9/26/2015.
 */

public class CodeScreen extends BasicScreen {
    Texture background;
    //TODO: More of LinkedList structure
    //TODO: Visualization of codeinterpreter
    ArrayList<UIBlock> activeBlocks = new ArrayList<UIBlock>();

    public CodeScreen(HackGT game) {
        super(game);
        background = new Texture("mainmenuscreen/MainMenuBackground.png");
    }

    @Override
    public void draw(float delta) {
        game.batch.draw(background, 0, 0, HackGT.CAMERA_WIDTH, HackGT.CAMERA_HEIGHT);
    }

    @Override
    public void updateObjects() {

    }

    @Override
    public void dispose() {
        background.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Input.Keys.SPACE == keycode) {
            game.switchScreen(HackGT.MAIN_MENU_SCREEN_NUMBER);
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
