package walkgame.objects.microObjects;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import walkgame.interfaces.Controllable;
import walkgame.interfaces.Moveable;

import java.util.Collection;

public class Map extends javafx.scene.Group implements Controllable, Moveable
{

    //todo: de map heeft 4 map propetys + een boolean die checkt of de player er voor het eerst is.

    private double speed = 1.5;
    private double velocityX = 0;
    private double velocityY = 0;

    private boolean goNorth, goSouth, goEast, goWest;


    public Map() {
        super.setLayoutX(0);
        super.setLayoutY(0);
    }

    public Map(Node... children) {
        super(children);
        super.setLayoutX(0);
        super.setLayoutY(0);
    }

    public Map(Collection<Node> children) {
        super(children);
        super.setLayoutX(0);
        super.setLayoutY(0);
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

        if(velocityX != 0 || velocityY != 0 ) {
            double x = getX();
            double y = getY();

            setX(x + velocityX);
            setY(y + velocityY);
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
    public double getX() {
        return super.getLayoutX();
    }

    @Override
    public double getY() {
        return super.getLayoutY();
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
    public void rotateImage(Coordinates mouseCoordinates) {
        return;
    }

    @Override
    public void rotateImage() {
        return;
    }
}
