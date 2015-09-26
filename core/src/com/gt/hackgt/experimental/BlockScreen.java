package com.gt.hackgt.experimental;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gt.hackgt.HackGT;
import com.gt.hackgt.codeinterpreter.blocks.BasicBlock;
import com.gt.hackgt.codeinterpreter.blocks.IntAssignmentBlock;
import com.gt.hackgt.utils.BasicScreen;

/**
 * Created by antonio on 9/26/15.
 */
public class BlockScreen extends BasicScreen {
    public static final int MIN_HEIGHT_BLOCK = 30;
    public static final int MAX_HEIGHT_BLOCK = 100;

    public static final int MIN_DISTANCE_BLOCK = 10;
    public static final int MAX_DISTANCE_BLOCK = 30;

    public static final int WIDTH_BLOCK = 100;

    public static final int BUFFER_HEIGHT = 30;

    private BasicBlock startBlock;
    private ShapeRenderer shapeRenderer;
    private int depth;
    private boolean wasPressed;

    public BlockScreen(HackGT game) {
        super(game);
        depth = 0;
        generateBlocks();
        shapeRenderer = new ShapeRenderer();
    }

    private void generateBlocks() {
        int count = 0;
        startBlock = new IntAssignmentBlock(null, "A");
        BasicBlock current = startBlock;
        while (count < 5) {
            current.setNextBlock(new IntAssignmentBlock(null, "B"));
            current = current.getNextBlock();
            count++;
        }
    }

    @Override
    public void dispose() {

    }

    @Override
    public void draw(float delta) {
        shapeRenderer.setProjectionMatrix(game.camera.combined);

        int middle = ((depth - 1) * (MIN_HEIGHT_BLOCK + MAX_DISTANCE_BLOCK)) / 2;

        int deltaMiddle = (HackGT.CAMERA_HEIGHT / 2) - middle;

        for (int i = 0 ; i < depth ; i ++) {
            int x = (HackGT.CAMERA_WIDTH - WIDTH_BLOCK) / 2;
            int y = (i * MIN_HEIGHT_BLOCK) + (i * MAX_DISTANCE_BLOCK) + deltaMiddle;
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(0f, 0f, 1f, 1f);
            shapeRenderer.rect(x, y, WIDTH_BLOCK, BUFFER_HEIGHT);
            shapeRenderer.end();
        }
    }

    @Override
    public void updateObjects() {
        depth = depthOfBlocks();
    }

    @Override
    public void checkKeys() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && !wasPressed) {
            BasicBlock current = startBlock;
            while (current.getNextBlock() != null) {
                current = current.getNextBlock();
            }
            current.setNextBlock(new IntAssignmentBlock(null, "A"));
            wasPressed = true;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && !wasPressed) {
            BasicBlock current = startBlock;
            while (current.getNextBlock().getNextBlock() != null) {
                current = current.getNextBlock();
            }
            current.setNextBlock(null);
            wasPressed = true;
        } else if (!Gdx.input.isKeyPressed(Input.Keys.DOWN) && !Gdx.input.isKeyPressed(Input.Keys.UP)) {
            wasPressed = false;
        }
    }

    /**
     * @return the number of blocks in a single line.
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
}
