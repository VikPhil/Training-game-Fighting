package main;

import inputs.KeyboardInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private int xPos = 50, yPos = 50;

    public GamePanel() {
        addKeyListener(new KeyboardInputs(this));
    }

    public void moveX(int value) {
        xPos += value;
    }
    public void moveY(int value) {
        yPos += value;
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.fillRect(xPos, yPos,100,100);
        repaint();
    }

}
