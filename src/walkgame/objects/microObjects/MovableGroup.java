package walkgame.objects.microObjects;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import walkgame.interfaces.Controllable;
import walkgame.interfaces.Moveable;
import walkgame.objects.hud.Player;
import walkgame.views.parentClasses.MainView;

import java.util.ArrayList;
import java.util.Collection;

public class MovableGroup extends javafx.scene.Group implements Controllable, Moveable
{
    private double speed = 1.5;
    private double velocityX = 0;
    private double velocityY = 0;

    private boolean goNorth, goSouth, goEast, goWest;


    public MovableGroup() {
        innit();
    }

    public MovableGroup(Node... children) {
        super(children);
        innit();
    }

    public MovableGroup(Collection<Node> children) {
        super(children);
        innit();
    }

    private void innit()
    {
        super.setLayoutX(0);
        super.setLayoutY(0);

        MainView.CONTROLLABLE_LIST.add(this);
        MainView.MOVEABLE_LIST.add(this);
    }

    @Override
    public void move() {
        if(!goNorth && !goSouth)
        {
            velocityY = 0;
        }
        if(!goEast && !goWest)
        {
            velocityX = 0;
        }

        checkCollision();

        if(velocityX != 0 || velocityY != 0 ) {
            double x = getX();
            double y = getY();

            setX(x + velocityX);
            setY(y + velocityY);
        }
    }

    private void checkCollision() {
        //check if player has collision with something sollit from player currents room
        Player player = MainView.getCurrentPlayer();
        player.setVelocityX(this.velocityX);
        player.setVelocityY(this.velocityY);

        ArrayList<Character> directionList = player.getCurrentRoom().getCollisionWith(player);

        if(directionList.contains(Compass.EAST) || directionList.contains(Compass.WEST))
        {
            this.velocityX = 0;
        }
        if(directionList.contains(Compass.NORTH) || directionList.contains(Compass.SOUTH))
        {
            this.velocityY = 0;
        }
    }

    @Override
    public double getVelocityX() {
        return this.velocityX;
    }

    @Override
    public double getVelocityY() {
        return this.velocityY;
    }

    @Override
    public Point2D getPoint2D()
    {
        Point2D point2D = new Point2D(this.getX(), this.getY());
        return point2D;
    }

    @Override
    public Point2D getMaxPoint2D()
    {
        Point2D point2D = new Point2D(this.getMaxX(), this.getMaxY());
        return point2D;
    }

    @Override
    public double getX() {
        return super.getLayoutX();
    }

    @Override
    public double getY() {
        return super.getLayoutY();
    }

    @Override
    public double getMaxX()
    {
        return this.getX() + getWidth();
    }

    @Override
    public double getMaxY()
    {
        return this.getY() + getHeight();
    }

    @Override
    public double getWidth()
    {
        return this.getBoundsInParent().getWidth();
    }

    @Override
    public double getHeight()
    {
        return this.getBoundsInParent().getHeight();
    }

    @Override
    public Point2D getSize()
    {
        return new Point2D(this.getWidth(), this.getHeight());
    }

    @Override
    public double getSceneHorizontalCenter()
    {
        return getX() + (getWidth() / 2f);
    }

    @Override
    public double getSceneVerticalCenter()
    {
        return getY() + (getHeight() / 2f);
    }

    @Override
    public Point2D getCenter()
    {
        return new Point2D(getSceneHorizontalCenter(), getSceneVerticalCenter());
    }

    @Override
    public double getSpeed() {
        return this.speed;
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
    public void setX(double x) {
        super.setLayoutX(x);
    }

    @Override
    public void setY(double y) {
        super.setLayoutY(y);
    }

    public Point2D getNegativePoint2D()
    {
        Point2D point2D = this.getPoint2D();
        double x = point2D.getX() * -1;
        double y = point2D.getY() * -1;



        return new Point2D(x , y);
    }

    @Override
    public void checkButton(Controlls controlls) {
        for(Key key : controlls.getPressedButtons())
        {
            pressButton(key);
        }
        for(Key key : controlls.getReleasedButtons())
        {
            releaseButton(key);
        }
    }

    private void pressButton(Key k) {
        if(k == Controlls.up) {
            setVelocityY(getSpeed());
            goNorth = true;
            goSouth = false;
        }
        else if(k == Controlls.right) {
            setVelocityX(0 - getSpeed());
            goEast = true;
            goWest = false;
        }
        else if(k == Controlls.down) {
            setVelocityY(0 - getSpeed());
            goSouth = true;
            goNorth = false;
        }
        else if(k == Controlls.left) {
            setVelocityX(getSpeed());
            goWest = true;
            goEast = false;
        }
    }

    private void releaseButton(Key k) {
        if(k == Controlls.up) {
            goNorth = false;
        }
        else if(k == Controlls.right) {
            goEast = false;
        }
        else if(k == Controlls.down) {
            goSouth = false;
        }
        else if(k == Controlls.left) {
            goWest = false;
        }
    }

    @Override
    public void rotateImage(Point2D mouseCoordinates) {
        return;
    }

    @Override
    public void rotateImage() {
        return;
    }
}
