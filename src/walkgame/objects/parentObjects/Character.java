package walkgame.objects.parentObjects;

import javafx.scene.image.Image;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;

public class Character extends GameObject implements Moveable, Destructible
{
    public Character(double x, double y, Image image, int health, double speed) {
        super(x, y, image);
        this.speed = speed;
        this.health = health;
    }

    private double speed = 0;
    private int health = 0;

    private double velocityX = 0;
    private double velocityY = 0;
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
        this.health = health;
    }

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
        int rotate = 0;

        if(goEast)
        {
            rotate = 90;
        }
        else if(goWest)
        {
            rotate = -90;
        }

        if(goNorth)
        {
            if(goEast)
            {
                rotate = 45;
            }
            else if(goWest)
            {
                rotate = -45;
            }
            else
            {
                rotate = 0;
            }
        }
        else if(goSouth)
        {
            if(goEast)
            {
                rotate = 135;
            }
            else if(goWest)
            {
                rotate = -135;
            }
            else
            {
                rotate = 180;
            }
        }

        super.setRotate(rotate);
    }
}
