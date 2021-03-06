package main;

import config.DefaultValues;
import entities.Player;
import levels.LevelManager;

import java.awt.*;

public class Game implements Runnable, DefaultValues {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread thread;
    private final int FPS = 120;
    private final int UPS = 200;

    private LevelManager levelManager;
    private Player player;

    public Game() {
        initialisationClasses();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startLoop();
    }

    private void initialisationClasses() {
        levelManager = new LevelManager(this);
        player = new Player( DEFAULT_POSITION_LEFT, FLOOR_HEIGHT, FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void startLoop() {
        thread = new Thread(this);
        thread.start();
    }

    public void gameUpdate()
    {
        levelManager.update();
        player.update();
    }

    public void gameRender(Graphics g) {
        levelManager.draw(g);
        player.render(g);
    }

    @Override
    public void run() {
        double timeFrame = 1_000_000_000.0 / FPS;
        double timeUpdate = 1_000_000_000.0 / UPS;
        long lastMillisFrame = System.currentTimeMillis();

        long prevTime = System.nanoTime(); // предыдущее время

        int frames = 0;
        int updates = 0;

        double dFrame = 0;
        double dUpdate = 0;

        while (true) {

            long currTime = System.nanoTime(); // текущее время
            dFrame += (currTime - prevTime) / timeFrame;
            dUpdate += (currTime - prevTime) / timeUpdate;
            prevTime = currTime;

            if (dUpdate >= 1) {
                gameUpdate();
                updates++;
                dUpdate--;
            }
            if (dFrame >= 1) {
                gamePanel.repaint();
                frames++;
                dFrame--;
            }

            if (System.currentTimeMillis() - lastMillisFrame >= 1000) {
                lastMillisFrame = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    public void focusLost() {
        player.resetDirection();
    }

    public Player getPlayer() {
        return player;
    }
}
