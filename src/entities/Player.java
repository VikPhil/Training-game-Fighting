package entities;

import config.Constants;
import config.Move;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static config.Constants.*;

public class Player extends Entity{
    private BufferedImage[][] animations;
    private int counterAnim = 0;
    private int indexAnim = 0;
    private final int speedAnim = 30;
    private Constants action = IDLE;
    private Move playerDirection;
    private boolean moving = false, attacking = false;
    private boolean left, right, jump, down;
    private float speedMoving = 1.0f;

    public Player(float xPos, float yPos) {
        super(xPos, yPos);
        loadFrames();
    }

    public void update() {
        moveX();
        updateFrames();
        setAnimation();
    }

    public void render(Graphics g) {

        g.drawImage(animations[action.getVolume()][indexAnim], (int)xPos, (int)yPos, 210, 200, null);

    }

    private void updateFrames() {
        counterAnim++;
        if(counterAnim >= speedAnim) {
            counterAnim = 0;
            indexAnim++;
            if(indexAnim >=  getNumberFrames(action)) {
                indexAnim = 0;
                attacking = false;
            }
        }
    }

    private void setAnimation() {

        int startAnim = action.getVolume();

        if(moving)
            action = WALK;
        else
            action = IDLE;

        if(attacking)
            action = KICK_FIST_1;

        if(startAnim != action.getVolume()) {
            counterAnim = 0;
            indexAnim = 0;
        }

    }

    public void moveX() {
        moving = false;

        if(left && !right) {
            xPos -= speedMoving;
            moving = true;
        }
        else if(right && !left) {
            xPos += speedMoving;
            moving = true;
        }

        if (jump && !down) {
            yPos -= speedMoving;
            moving = true;
        }
        else if(down && !jump) {
            yPos += speedMoving;
            moving = true;
        }
    }

    private void loadFrames() {
        InputStream is = getClass().getResourceAsStream("/fighter_one_sprites.png"); // импорт картинки
        try {
            BufferedImage img = ImageIO.read(is);

            animations = new BufferedImage[5][8];
            for (int y = 0; y < animations.length; y++)
                for (int x = 0; x < animations[y].length; x++) {
                    animations[y][x] = img.getSubimage(x * 105, y * 100, 105, 100);
                }
        } catch (IOException e) {
            e.printStackTrace();
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
