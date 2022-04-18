package entities;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Entity {
    protected float xPos, yPos;
    protected int width, height;
    protected Rectangle2D.Float rectangle;

    protected Entity(float xPos, float yPos, int width,int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;

    }

    protected void initRectangle(float x, float y, float width, float height) {

        rectangle = new Rectangle2D.Float(xPos, yPos, width, height);
    }

    protected void drawRectangle(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect((int)rectangle.x, (int)rectangle.y, (int)rectangle.width, (int)rectangle.height);
    }

    public Rectangle2D.Float getRectangle() {
        return rectangle;
    }
}
