package com.gt.hackgt.gameobject;

/**
 * Created by Lauren on 9/25/2015.
 */
import com.badlogic.gdx.graphics.Texture;
import java.util.ArrayList;

public abstract class GameObject {

    //Could add more directions at some point.
    public enum Direction {
        N, S, E, W
    }

    private Texture texture;
    private float transparency;
    private int xPosition;
    private int yPosition;

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
    public abstract void rotate(int degrees);

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
}
