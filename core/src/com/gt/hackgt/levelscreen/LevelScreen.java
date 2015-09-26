package com.gt.hackgt.levelscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.gt.hackgt.HackGT;
import com.gt.hackgt.gameobject.GameObject;
import com.gt.hackgt.utils.BasicScreen;
import com.gt.hackgt.utils.KeyDownListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a singular level in the game.
 */
public class LevelScreen extends BasicScreen {
    public final static int PLAYGROUND_WIDTH = 450;
    public final static int PLAYGROUND_HEIGHT = 480;

    private Stage stage;
    private GameObject playerObject;
    private GameObject background;
    private List<KeyDownListener> keyDownListenerList;

    public LevelScreen(HackGT game) {
        super(game);
        stage = new Stage(new ScreenViewport(game.camera));
        Gdx.input.setInputProcessor(this);
        loadPlayer();
        loadBackground();
        addPlayerKeyboadList();
    }

    private void loadPlayer() {
        playerObject = new GameObject();
        playerObject.setTexture(new Texture("badlogic.jpg"));
        playerObject.setSize(64, 48);
        stage.addActor(playerObject);
    }

    private void loadBackground() {
        background = new GameObject();
        background.setTexture(new Texture("levelscreen/background.jpg"));
        background.setSize(PLAYGROUND_WIDTH, stage.getHeight());
        stage.addActor(background);
        background.toBack();
    }

    private void addPlayerKeyboadList() {
        keyDownListenerList = new ArrayList<KeyDownListener>();

        keyDownListenerList.add(new KeyDownListener(Input.Keys.W) {
            @Override
            public void event() {
                playerObject.moveUp();
            }
        });

        keyDownListenerList.add(new KeyDownListener(Input.Keys.S) {
            @Override
            public void event() {
                playerObject.moveDown();
            }
        });

        keyDownListenerList.add(new KeyDownListener(Input.Keys.A) {
            @Override
            public void event() {
                playerObject.moveLeft();
            }
        });

        keyDownListenerList.add(new KeyDownListener(Input.Keys.D) {
            @Override
            public void event() {
                playerObject.moveRight();
            }
        });
    }

    @Override
    public void dispose() {

    }

    @Override
    public void draw(float delta) {
        stage.draw();
        for (KeyDownListener listener : keyDownListenerList) {
            listener.doEvent();
        }
    }

    @Override
    public void updateObjects() {
        stage.act();
    }

    @Override
    public boolean keyDown(int keycode) {
        for (KeyDownListener listener : keyDownListenerList) {
            if (listener.keyDown(keycode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        for (KeyDownListener listener : keyDownListenerList) {
            if (listener.keyUp(keycode)) {
                return true;
            }
        }
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
