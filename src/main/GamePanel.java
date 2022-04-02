package main;

import config.Constants;
import inputs.KeyboardInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static config.Constants.*;


public class GamePanel extends JPanel {

    private int xPos = 50, yPos = 50;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int counterAnim = 0, indexAnim = 0, speedAnim = 20;
    private Constants action = KICK_FIST_2;

    public GamePanel() {
        addKeyListener(new KeyboardInputs(this));
        uploadImage();
        loadFrames();
    }

    private void loadFrames() {
        animations = new BufferedImage[5][8];
        for (int y = 0; y < animations.length; y++)
            for (int x = 0; x < animations[y].length; x++) {
                animations[y][x] = img.getSubimage(x * 105, y * 100, 105, 100);
            }
    }

    private void updateFrames() {
        counterAnim++;
        if(counterAnim >= speedAnim) {
            counterAnim = 0;
            indexAnim++;
            if(indexAnim >=  getNumberFrames(action))
                indexAnim = 0;
        }
    }

    private void uploadImage() {
        InputStream is = getClass().getResourceAsStream("/fighter_one_sprites.png"); // импорт картинки
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void moveX(int value) {
        xPos += value;
    }

    public void moveY(int value) {
        yPos += value;
    }

    public void paint(Graphics g) {
        super.paint(g);

        updateFrames();
        g.drawImage(animations[action.getVolume()][indexAnim], xPos, yPos, 210, 200, null);

    }

}
