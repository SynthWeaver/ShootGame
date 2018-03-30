package walkgame.objects.parentClasses;

import gameloop.GameLoop;
import javafx.scene.image.Image;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.Sprites;

public abstract class Character extends ImageViewObject implements Moveable, Destructible
{
    public Character(Sprites sprites, Coordinates coordinates, int health, double speed) {
        super(coordinates);
        this.speed = speed;
        this.sprites = sprites;
        this.health = health;
    }

    private int health = 0;
    private double speed = 0;

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
        this.health = health;
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
    public int getHealth() {
        return this.health;
    }

    public void destroy()
    {
        this.setHealth(0);
        GameLoop.doLogicUpdate();
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
        Image image = sprites.getSprite(Coordinates.SOUTH);

        if(goEast)
        {
            image = sprites.getSprite(Coordinates.EAST);
        }
        else if(goWest)
        {
            image = sprites.getSprite(Coordinates.WEST);
        }

        if(goNorth)
        {
            if(goEast)
            {
                image = sprites.getSprite(Coordinates.NORTH_EAST);
            }
            else if(goWest)
            {
                image = sprites.getSprite(Coordinates.NORTH_WEST);
            }
            else
            {
                image = sprites.getSprite(Coordinates.NORTH);
            }
        }
        else if(goSouth)
        {
            if(goEast)
            {
                image = sprites.getSprite(Coordinates.SOUTH_EAST);
            }
            else if(goWest)
            {
                image = sprites.getSprite(Coordinates.SOUTH_WEST);
            }
            else
            {
                image = sprites.getSprite(Coordinates.SOUTH);
            }
        }

        super.setImage(image);
    }
}
