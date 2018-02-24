package walkgame.objects;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import walkgame.interfaces.Controllable;
import walkgame.interfaces.Moveable;
import walkgame.objects.parentObjects.GameObject;

import java.util.ArrayList;

public class Floor extends GameObject implements Controllable, Moveable
{
    public static ArrayList<Floor> floorList = new ArrayList<>();

    public Floor(double x, double y, Image image) {
        super(x, y, image);
        Floor.floorList.add(this);
    }

    private double speed = 1.5;
    private double velocityX = 0;
    private double velocityY = 0;
    public boolean goNorth, goSouth, goEast, goWest;

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

        if(velocityX != 0 || velocityY != 0 ) {
            double x = getX();
            double y = getY();

            super.setX(x + velocityX);
            super.setY(y + velocityY);
        }
    }


    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public double getSpeed() {
        return this.speed;
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
    public void pressButton(KeyCode c) {
        switch (c){
            case W:
                setVelocityY(getSpeed());
                goNorth = true;
                goSouth = false;
                break;
            case D:
                setVelocityX(0 - getSpeed());
                goEast = true;
                goWest = false;
                break;
            case S:
                setVelocityY(0 - getSpeed());
                goSouth = true;
                goNorth = false;
                break;
            case A:
                setVelocityX(getSpeed());
                goWest = true;
                goEast = false;
                break;
        }
    }

    @Override
    public void releaseButton(KeyCode c) {
        switch (c){
            case W: goNorth = false; break;
            case D: goEast = false; break;
            case S: goSouth = false; break;
            case A: goWest = false; break;
        }
    }

    @Override
    public void rotateImage() {
        return;
    }
}
