package main;

public class Game implements Runnable{

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread thread;
    private final int FPS = 120;

    public Game() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startLoop();
    }

    private void startLoop() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double timeFrame = 1_000_000_000.0 / FPS;
        long lastFrame = System.nanoTime();
        long lastMillisFrame = System.currentTimeMillis();
        int frames = 0;

        while(true) {
            if(System.nanoTime() - lastFrame >= timeFrame) {
                gamePanel.repaint();
                lastFrame = System.nanoTime();
                frames++;
            }

            if(System.currentTimeMillis() - lastMillisFrame >= 1000) {
                lastMillisFrame = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }
}
