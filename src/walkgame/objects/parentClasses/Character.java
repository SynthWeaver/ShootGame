package walkgame.objects.parentClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;
import walkgame.objects.microObjects.Angle;
import walkgame.objects.microObjects.Sprites;

public abstract class Character extends ImageViewObject implements Moveable, Destructible
{
    public Character(Sprites sprites, Point2D coordinates, SimpleIntegerProperty health, double speed) {
        super(coordinates);
        this.speed = speed;
        this.sprites = sprites;
        this.health = health;
    }

    private SimpleIntegerProperty health;
    private double speed;

    private double velocityX = 0, velocityY = 0;
    protected boolean goNorth, goSouth, goEast, goWest;

    protected Sprites sprites;



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
        Image image = sprites.getSprite(Angle.SOUTH);

        if(goEast)
        {
            image = sprites.getSprite(Angle.EAST);
        }
        else if(goWest)
        {
            image = sprites.getSprite(Angle.WEST);
        }

        if(goNorth)
        {
            if(goEast)
            {
                image = sprites.getSprite(Angle.NORTH_EAST);
            }
            else if(goWest)
            {
                image = sprites.getSprite(Angle.NORTH_WEST);
            }
            else
            {
                image = sprites.getSprite(Angle.NORTH);
            }
        }
        else if(goSouth)
        {
            if(goEast)
            {
                image = sprites.getSprite(Angle.SOUTH_EAST);
            }
            else if(goWest)
            {
                image = sprites.getSprite(Angle.SOUTH_WEST);
            }
            else
            {
                image = sprites.getSprite(Angle.SOUTH);
            }
        }

        super.setImage(image);
    }
}
