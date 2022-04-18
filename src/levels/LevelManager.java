package levels;

import config.DefaultValues;
import config.LoadFrame;
import main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelManager {
    private Game game;
    private BufferedImage levelImg;
    public LevelManager(Game game) {
        this.game = game;
        levelImg = LoadFrame.getSprites(DefaultValues.SPRITE_LEVEL);
    }

    public void draw(Graphics g) {
        g.drawImage(levelImg,0, 0,DefaultValues.WINDOW_WIDTH, DefaultValues.WINDOW_HEIGHT, null);
    }

    public void update() {

    }
}
