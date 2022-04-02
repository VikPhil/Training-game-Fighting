package main;

import javax.swing.*;

public class GameWindow {

    private JFrame jFrame;
    public GameWindow(GamePanel gamePanel) {
        jFrame = new JFrame();

        jFrame.setSize(1024, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        //jFrame.setResizable(false);
        jFrame.add(gamePanel);
        jFrame.setVisible(true);
    }
}
