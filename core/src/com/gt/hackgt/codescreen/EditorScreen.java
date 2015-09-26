package com.gt.hackgt.codescreen;

import com.badlogic.gdx.Input;
import com.gt.hackgt.HackGT;
import com.gt.hackgt.codeinterpreter.blocks.BasicBlock;
import com.gt.hackgt.codeinterpreter.blocks.IfBlock;
import com.gt.hackgt.codeinterpreter.blocks.IntAssignmentBlock;
import com.gt.hackgt.utils.BasicScreen;

/**
 * Created by antonio on 9/26/15.
 */
public class EditorScreen extends BasicScreen {
    public static final int BLOCK_HEIGHT = 22;
    public static final int BLOCK_WIDTH = 75;
    public static final int BLOCK_SPACE = 6;

    private BasicBlock startBlock;
    private int depth;
    private boolean wasPressed;

    public EditorScreen(HackGT game) {
        super(game);
        startBlock = null;
        depth = 0;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void draw(float delta) {
        BasicBlock current = startBlock;
        while (current != null) {
            current.draw(game.batch, game.font);
            current = current.getNextBlock();
        }
        game.font.draw(game.batch, "HELLO!!!!", 0, 0);
    }

    @Override
    public void updateObjects() {
        depth = depthOfBlocks();
        System.out.println(depth);
        int offset = offsetCenter();

        BasicBlock current = startBlock;
        for (int i = 0 ; i < depth ; i ++) {
            int x = (HackGT.CAMERA_WIDTH - BLOCK_WIDTH) / 2;
            int y = (i * BLOCK_HEIGHT) + (i * BLOCK_SPACE) + offset;
            current.setXPosition(x);
            current.setYPosition(y);
            current.setWidth(BLOCK_WIDTH);
            current.setHeight(BLOCK_HEIGHT);
            current = current.getNextBlock();
        }
    }

    /**
     * @returns the number of blocks in the current script.
     */
    private int depthOfBlocks() {
        BasicBlock current = startBlock;
        int count = 0;
        while (current != null) {
            count++;
            current = current.getNextBlock();
        }
        return count;
    }

    /**
     * @returns the offset each block must have in the y in order for the center of all blocks to be in the middle.
     */
    private int offsetCenter() {
        return (HackGT.CAMERA_HEIGHT / 2) - ((depth - 1) * (BLOCK_HEIGHT + BLOCK_SPACE)) / 2;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.UP && !wasPressed) {
            BasicBlock current = startBlock;
            if (current != null) {
                while (current.getNextBlock() != null) {
                    current = current.getNextBlock();
                }
                current.setNextBlock(new IfBlock(null));
            } else {
                startBlock = new IntAssignmentBlock(null, "A");
            }

            wasPressed = true;
            return true;
        } else if (keycode == Input.Keys.DOWN && !wasPressed) {
            if (depth > 0) {
                BasicBlock current = startBlock;
                while (current.getNextBlock().getNextBlock() != null) {
                    current = current.getNextBlock();
                }
                current.setNextBlock(null);
                wasPressed = true;
            }
        } else if (keycode != Input.Keys.DOWN && keycode != Input.Keys.UP) {
            wasPressed = false;
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
