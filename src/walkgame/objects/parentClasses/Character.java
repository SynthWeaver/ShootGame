package walkgame.objects.parentClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;
import walkgame.interfaces.Solid;
import walkgame.objects.microObjects.Angle;

public abstract class Character extends StackPaneObject implements Moveable, Destructible, Solid
{
    public Character(Image[] image, Point2D coordinates, SimpleIntegerProperty health, double speed) {
        super(image, coordinates);
        this.speed = speed;
        this.health = health;
    }

    private SimpleIntegerProperty health;
    private double speed;

    private double velocityX = 0, velocityY = 0;
    protected boolean goNorth, goSouth, goEast, goWest;



    public double getSpeed()
    {
        return this.speed;
    }



    @Override
    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setVelocityX(double velocity) {
        this.velocityX = velocity;
    }

    public void setVelocityY(double velocity) {
        this.velocityY = velocity;
    }

    @Override
    public void setHealth(int health)
    {
        this.health.set(health);
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
    public SimpleIntegerProperty getHealth() {
        return this.health;
    }

    public abstract void destroy();

    @Override
    public void move()
    {
        if(goNorth || goEast || goSouth || goWest) {
            rotateImage();
        }

        if(!goNorth && !goSouth)
        {
            velocityY = 0;
        }
        if(!goEast && !goWest)
        {
            velocityX = 0;
        }

        if(velocityX != 0 && velocityY != 0 ) {
            double x = getX();
            double y = getY();

            super.setX(x + velocityX);
            super.setY(y + velocityY);
        }
    }



    @Override
    public void rotateImage() {
        double rotate = 0;

        if(goEast)
        {
            rotate = Angle.EAST;
        }
        else if(goWest)
        {
            rotate = Angle.WEST;
        }

        if(goNorth)
        {
            if(goEast)
            {
                rotate = Angle.NORTH_EAST;
            }
            else if(goWest)
            {
                rotate = Angle.NORTH_WEST;
            }
            else
            {
                rotate = Angle.NORTH;
            }
        }
        else if(goSouth)
        {
            if(goEast)
            {
                rotate = Angle.SOUTH_EAST;
            }
            else if(goWest)
            {
                rotate = Angle.SOUTH_WEST;
            }
            else
            {
                rotate = Angle.SOUTH;
            }
        }

        super.setRotate(rotate);
    }
}
