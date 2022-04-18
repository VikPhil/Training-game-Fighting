package entities;

import static config.DefaultValues.*;
import static config.StoppingLogic.CanMove;
import config.Constants;
import config.LoadFrame;
import config.Move;

import java.awt.*;
import java.awt.image.BufferedImage;

import static config.Constants.*;

public class Player extends Entity {
    private BufferedImage[][] animations;
    private int counterAnim = 0;
    private int indexAnim = 0;
    private final int speedAnim = 30;
    private Constants action = IDLE;
    private Move playerDirection;
    private boolean moving = false, attacking = false, inAir = false;
    private boolean left, right, jump, down;
    private float speedMoving = 1.0f;
    private float xDrawOffset = 20 * SCALE;
    private float yDrawOffset = -1 * SCALE;

    //для прыжка
    private  final float GRAVITY = 0.02f * SCALE;
    private float speedFall = 0.0f;
    private float jumpSpeed = -2.5f * SCALE;

    public Player(float xPos, float yPos, int width, int height) {
        super(xPos, yPos, width, height);
        loadFrames();
        initRectangle(xPos, yPos, 58 * SCALE, 100 * SCALE);
    }

    public void update() {
        moveX();
        updateFrames();
        setAnimation();
    }

    public void render(Graphics g) {

        g.drawImage(animations[action.getVolume()][indexAnim],(int)(rectangle.x - xDrawOffset), (int) (rectangle.y - yDrawOffset), width, height, null);
        drawRectangle(g);
    }

    private void updateFrames() {
        counterAnim++;
        if (counterAnim >= speedAnim) {
            counterAnim = 0;
            indexAnim++;
            if (indexAnim >= getNumberFrames(action)) {
                indexAnim = 0;
                attacking = false;
            }
        }
    }

    private void setAnimation() {

        int startAnim = action.getVolume();

        if (moving)
            action = WALK;
        else
            action = IDLE;

//        if(inAir) {
//            if(speedFall < 0)
//                action = JUMP;
//            else
//                action = IDLE;
//        }

        if (attacking)
            action = KICK_FIST_1;

        if (startAnim != action.getVolume()) {
            counterAnim = 0;
            indexAnim = 0;
        }

    }

    public void moveX() {
        moving = false;
        if (!left && !right && !inAir)
            return;

        if(jump) {
            jump();
        }

        float xSpeed = 0;
        if (left)
            xSpeed -= speedMoving;
        if (right)
            xSpeed += speedMoving;

        if(inAir) {
            if(CanMove(rectangle.x, rectangle.y + speedFall, rectangle.width, rectangle.height)){
                rectangle.y += speedFall;
                speedFall += GRAVITY;
                updateXPos(xSpeed);
            }else {
                rectangle.y = FLOOR_HEIGHT;
                if(speedFall > 0)
                    resetInAir();
                updateXPos(xSpeed);
            }
        }else
            updateXPos(xSpeed);
        moving = true;
    }

    private void jump() {
        if(inAir)
            return;
        inAir = true;
        speedFall = jumpSpeed;
    }

    private void resetInAir() {
        inAir = false;
        speedFall = 0;
    }

    private void updateXPos(float xSpeed) {
        if(CanMove(rectangle.x + xSpeed, rectangle.y, rectangle.width, rectangle.height)) {
            rectangle.x += xSpeed;
        }
    }

    private void loadFrames() {
        BufferedImage img = LoadFrame.getSprites(LoadFrame.SPRITE_FIGHTER_ONE);
        animations = new BufferedImage[5][8];
        for (int y = 0; y < animations.length; y++)
            for (int x = 0; x < animations[y].length; x++) {
                animations[y][x] = img.getSubimage(x * FRAME_WIDTH, y * FRAME_HEIGHT, FRAME_WIDTH, FRAME_HEIGHT);
            }

    }

    public void resetDirection() {
        left = false;
        right = false;
        jump = false;
        down = false;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isJump() {
        return jump;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
