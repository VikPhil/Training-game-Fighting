package config;

import main.GameWindow;

import java.awt.geom.Rectangle2D;

public class StoppingLogic {
    public static boolean CanMove(float x, float y, float width, float height) {
        if(!isSolid(x, y))
            if(!isSolid(x + width, y + height))
                if(!isSolid(x + width, y))
                    if(!isSolid(x, y + height))
                        return true;
        return false;
    }

    private static boolean isSolid(float x, float y) {
        if(x < 0 || x >= GameWindow.WINDOW_WIDTH)
            return true;
        if(y < 0 || y > GameWindow.WINDOW_HEIGHT - GameWindow.CELL_SIZE)
            return true;
        return false;
    }

}
