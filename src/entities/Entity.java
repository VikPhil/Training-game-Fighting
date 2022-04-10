package entities;

public abstract class Entity {
    protected float xPos;
    protected float yPos;
    protected Entity(float xPos, float yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
}
