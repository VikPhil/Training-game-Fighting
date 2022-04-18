package main;

import inputs.KeyboardInputs;

import javax.swing.*;
import java.awt.*;

import static config.DefaultValues.WINDOW_HEIGHT;
import static config.DefaultValues.WINDOW_WIDTH;

public class GamePanel extends JPanel {

    private Game game;
    public GamePanel(Game game) {

        this.game = game;
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
    }

    private void setPanelSize() {
        Dimension size = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
        setPreferredSize(size);
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
