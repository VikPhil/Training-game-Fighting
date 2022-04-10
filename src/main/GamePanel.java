package main;

import inputs.KeyboardInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private Game game;
    public GamePanel(Game game) {
        this.game = game;
        addKeyListener(new KeyboardInputs(this));
    }

    public void gameUpdate() {

    }

    public void paint(Graphics g) {
        super.paint(g);

        game.gameRender(g);
    }

    public Game getGame() {
        return game;
    }
}
