package walkgame.objects.microObjects;

import gameloop.GameLoop;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import walkgame.interfaces.Controllable;
import walkgame.interfaces.Moveable;
import walkgame.objects.hud.Player;
import walkgame.objects.parentClasses.ImageViewObject;
import walkgame.views.parentClasses.MainView;

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

        if(velocityX == 0 && velocityY == 0 ) {
            return;
        }

        Player player = (Player) Player.group.getChildren().get(0);
        ImageView dummyPlayer = player.getRelativePlayer();
        for (Node node : MainView.getListOfAllNodes())
        {
            if(node instanceof ImageViewObject && !node.equals(player))
            {
                ImageViewObject object = (ImageViewObject) node;
                if(object.isSolid())
                {
                    //North + South
                    if(dummyPlayer.contains(object.getX() , object.getTotalHeight() + velocityY) || dummyPlayer.contains(object.getX() , object.getY() + velocityY))
                    {
                        velocityY = 0;
                    }
                    //East + West
                    if(dummyPlayer.contains(object.getX() + velocityX, object.getY()) || dummyPlayer.contains(object.getTotalWidth() + velocityX, object.getTotalHeight()))
                    {
                        velocityX = 0;
                    }
                    //if(velocityX == 0 && velocityY == 0){return;}
                }
            }
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
    public Coordinates getCoordinate()
    {
        return new Coordinates(getX(), getY());
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

    @Override
    public void pressButton(Key k) {
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

    @Override
    public void releaseButton(Key k) {
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
    public void rotateImage(Coordinates mouseCoordinates) {
        return;
    }

    @Override
    public void rotateImage() {
        return;
    }
}
