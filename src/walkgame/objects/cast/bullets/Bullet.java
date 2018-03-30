package walkgame.objects.cast.bullets;

import gameloop.GameLoop;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Group;
import javafx.scene.image.Image;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.Functions;
import walkgame.objects.parentClasses.ImageViewObject;
import walkgame.views.parentClasses.MainView;

public abstract class Bullet extends ImageViewObject implements Moveable, Destructible {

    public static Group group = new Group();

    private static final SimpleIntegerProperty DEFAULT_HEALTH = new SimpleIntegerProperty(1);
    private static final double DEFAULT_SPEED = 4;

    private SimpleIntegerProperty health;
    private double speed;
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
        angle -= 90;

        this.velocityX = this.speed * Math.cos((angle/180) * Math.PI);
        this.velocityY = this.speed * Math.sin((angle/180) * Math.PI);
    }

    @Override
    public void addNodeToList()
    {
        Bullet.group.getChildren().add(this);
    }

    @Override
    public void destroy()
    {
        Bullet.group.getChildren().remove(this);
        GameLoop.doLogicUpdate();
    }

    @Override
    public SimpleIntegerProperty getHealth() {
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
        this.health.set(health);
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
        double x = super.getX();
        double y = super.getY();

        Coordinates screen = new Coordinates(0,0).relativiseCoordinates();
        Coordinates screenSize = MainView.screenSize.relativiseCoordinates();

        if(x > screenSize.getX() + 20 || x < screen.getX() - 20)
        {
            this.setHealth(0);
        }
        else if(y > screenSize.getY() + 20 || y < screen.getY() - 20)
        {
            this.setHealth(0);
        }
        else
        {
            super.setX(x + velocityX);
            super.setY(y + velocityY);
        }
    }

    @Override
    public void rotateImage() {

    }
}
