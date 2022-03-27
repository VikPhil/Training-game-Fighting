package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                // вверх
                gamePanel.moveY(-5);
                break;
            case KeyEvent.VK_S:
                // вниз
                gamePanel.moveY(5);
                break;
            case KeyEvent.VK_A:
                // влево
                gamePanel.moveX(-5);
                break;
            case KeyEvent.VK_D:
                // вправо
                gamePanel.moveX(5);
                break;
            case KeyEvent.VK_U:
                // удар рукой
                break;
            case KeyEvent.VK_J:
                // удар рукойAlt
                break;
            case KeyEvent.VK_I:
                // удар ногой
                break;
            case KeyEvent.VK_K:
                // удар ногойAlt
                break;
            case KeyEvent.VK_SPACE:
                // блок
                System.out.println("нажат пробел");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
