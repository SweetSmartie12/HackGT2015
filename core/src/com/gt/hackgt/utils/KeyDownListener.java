package com.gt.hackgt.utils;

/**
 * Continually does an action until the key is released.
 */
public abstract class KeyDownListener {
    private int keyCode;
    private boolean isKeyPressed;

    public KeyDownListener(int code) {
        keyCode = code;
    }

    public void doEvent() {
        if (isKeyPressed) {
            event();
        }
    }

    public abstract void event();

    public boolean keyDown(int keyCode) {
        if (this.keyCode == keyCode) {
            isKeyPressed = true;
            return true;
        }
        return false;
    }

    public boolean keyUp(int keyCode) {
        if (this.keyCode == keyCode) {
            isKeyPressed = false;
            return true;
        }
        return false;
    }
}
