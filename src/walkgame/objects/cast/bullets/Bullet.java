package walkgame.objects.cast.bullets;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;
import walkgame.objects.hud.Hud;
import walkgame.objects.hud.Player;
import walkgame.objects.microObjects.Functions;
import walkgame.objects.parentClasses.ImageViewObject;
import walkgame.views.parentClasses.MainView;

public abstract class Bullet extends ImageViewObject implements Moveable, Destructible {

    public static Group group = new Group();

    private static final int DEFAULT_HEALTH = 1;
    private static final double DEFAULT_SPEED = 4;
    private static final boolean isSolid = true;

    private SimpleIntegerProperty health = new SimpleIntegerProperty();
    private double speed;
    private double velocityX = 0, velocityY = 0;

    public Bullet(Image image, Point2D startingCoordinates, Point2D directionCoordinates) {
        super(image, startingCoordinates);
        this.health.set(DEFAULT_HEALTH);
        this.speed = DEFAULT_SPEED;

        shoot(directionCoordinates);
    }

    private void shoot(Point2D directionCoordinates)
    {
        double angle = Functions.getAngle(super.getPoint2D(), directionCoordinates);
        angle -= 90;

        this.velocityX = this.speed * Math.cos((angle/180) * Math.PI);
        this.velocityY = this.speed * Math.sin((angle/180) * Math.PI);
    }

    @Override
    public void destroy()
    {
        Bullet.group.getChildren().remove(this);
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

        Point2D screen = Hud.hudToMovableGroup(new Point2D(0,0));
        Point2D screenSize = Hud.hudToMovableGroup(MainView.screenSize);

        if(hasCollision())//todo: een of andere bug kan ik door de muur schieten (links boven schuin)
        {
            this.setHealth(0);
        }
        else if(x > screenSize.getX() + 20 || x < screen.getX() - 20)
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

    private boolean hasCollision()
    {

        for(Node node : Player.group.getChildren())
        {
            Player player = (Player) node;
            if(player.getCurrentRoom().hasCollisionWith(this))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void rotateImage() {

    }

    @Override
    public boolean isSolid() {
        return isSolid;
    }

    @Override
    public void addNodeToList()
    {
        Bullet.group.getChildren().add(this);

        MainView.DESTRUCTIBLE_LIST.add(this);
        MainView.MOVEABLE_LIST.add(this);
    }
}
