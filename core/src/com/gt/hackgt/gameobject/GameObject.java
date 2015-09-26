package com.gt.hackgt.gameobject;

/**
 * Created by Lauren on 9/25/2015.
 */

import com.badlogic.gdx.graphics.Texture;
import com.gt.hackgt.codeinterpreter.DataObject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public abstract class GameObject implements KeyListener {

    //Could add more directions at some point.
    public enum Direction {
        N, S, E, W
    }

    private Texture texture;
    private float transparency;
    private int xPosition;
    private int yPosition;
    private int stepSize;

    //The direction that the game object is facing
    private Direction direction;

    private int width;
    private int height;

    //TODO: add actual references here, this is just temp
    int gameWidth = 640;
    int gameHeight = 480;

    private String name;

    private int drawPriority;

    private ArrayList<String> tags;
    private ArrayList<Object> additionalFields;

    public void setTransparency(float transparency) {
        this.transparency = transparency;
    }

    public int getPriority() {
        return drawPriority;
    }

    public void setYPosition(int y) {
        this.yPosition = y;
    }

    public void setXPosition(int x) {
        this.xPosition = x;
    }

    public void moveUp() {
        if (this.yPosition > 0) {
            this.yPosition--;
        }
    }

    public void moveDown() {
        if (this.yPosition < gameHeight) {
            this.yPosition++;
        }
    }

    public void moveLeft() {
        if (this.xPosition > 0) {
            this.xPosition--;
        }
    }

    public void moveRight() {
        if (this.xPosition < gameWidth) {
            this.xPosition++;
        }
    }

    //This is gonna depend on what each game object is. Or math.
    //Assume in simplest case that degrees can be 90, 180, or 270
    public void rotate(int degrees) {
        Direction[] rotationMatrix = {Direction.N, Direction.E, Direction.S, Direction.W};
        int index = degrees / 90;
        if (direction == Direction.N) {
            direction = rotationMatrix[index];
        } else if (direction == Direction.E) {
            direction = rotationMatrix[(1 + index)%4];
        } else if (direction == Direction.S) {
            direction = rotationMatrix[(2 + index)%4];
        } else if (direction == Direction.W) {
            direction = rotationMatrix[(3 + index)%4];
        }
    }

    public void moveForward() {
        move(1);
    }

    public void moveBackward() {
        move(-1);
    }

    protected void move(int steps) {
        if ((direction == Direction.N && yPosition > 0)|| (direction == Direction.S && yPosition < gameHeight)) {
            yPosition += steps;
        } else if ((direction == Direction.E && xPosition > 0) || (direction == Direction.W && xPosition < gameWidth)) {
            xPosition += steps;
        }
    }

    public abstract void keyPressed(KeyEvent e);

    public void executeSystemCall(String function, DataObject arg1, DataObject arg2) {
        // TODO(acalabrese): This doesn't do anything currently, you need to do something with this.
        // I am thinking that we have a pseudo runnable function for each system call, and use the function string
        // as a key into a map that gets us this system function. This would have the added benefit of forcing us to add
        // the system call only if it is useful for the user.
    }
}
