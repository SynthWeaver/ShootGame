package walkgame.objects.bullets;

import javafx.scene.image.Image;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.Functions;
import walkgame.objects.parentObjects.GameObject;

public abstract class Bullet extends GameObject implements Moveable, Destructible {

    private static final int DEFAULT_HEALTH = 1;
    private static final double DEFAULT_SPEED = 4;

    private int health = 0;
    private double speed = 0;
    private double velocityX = 0, velocityY = 0;

    public Bullet(Image image, Coordinates startingCoordinates, Coordinates directionCoordinates) {
        super(image, startingCoordinates);
        this.health = DEFAULT_HEALTH;
        this.speed = DEFAULT_SPEED;

        shoot(directionCoordinates);
    }

    private void shoot(Coordinates directionCoordinates)
    {
        double angle = Functions.getAngle(super.getCoordinate(), directionCoordinates);

        this.velocityX = this.speed * (float)Math.cos((angle/180)*Math.PI);
        this.velocityY = this.speed * (float)Math.sin((angle/180)*Math.PI);
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public double getVelocityX() {
        return velocityX;
    }

    @Override
    public double getVelocityY() {
        return velocityY;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void setVelocityX(double velocity) {
        this.velocityX = velocity;
    }

    @Override
    public void setVelocityY(double velocity) {
        this.velocityY = velocity;
    }

    @Override
    public void move() {

    }

    @Override
    public void rotateImage() {

    }
}
