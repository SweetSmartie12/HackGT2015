package com.gt.hackgt.codescreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.gt.hackgt.HackGT;

/**
 * Created by Lauren on 9/26/2015.
 */
import com.badlogic.gdx.graphics.Texture;
import com.gt.hackgt.codeinterpreter.UIBlock;
import com.gt.hackgt.utils.BasicScreen;

import java.util.ArrayList;

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
