package walkgame.objects.bullets;

import javafx.scene.image.Image;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentObjects.GameObject;

public abstract class Bullet extends GameObject implements Moveable, Destructible {

    private static final int DEFAULT_HEALTH = 1;
    public static final int PISTOL_BULLET_ID = 0;

    private int bulletId;

    public Bullet(int bulletId, Image image, Coordinates coordinates) {
        super(image, coordinates, DEFAULT_HEALTH);
        this.bulletId = bulletId;
    }

    @Override
    public void setHealth(int health) {

    }

    @Override
    public void move() {

    }

    @Override
    public void rotateImage() {

    }

    @Override
    public void setSpeed(double speed) {

    }

    @Override
    public void setVelocityX(double velocity) {

    }

    @Override
    public void setVelocityY(double velocity) {

    }

    @Override
    public double getSpeed() {
        return 0;
    }

    @Override
    public double getVelocityX() {
        return 0;
    }

    @Override
    public double getVelocityY() {
        return 0;
    }
}
