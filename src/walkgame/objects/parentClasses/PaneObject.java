package walkgame.objects.parentClasses;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import walkgame.interfaces.NodeInterface;
import walkgame.objects.microObjects.Compass;
import walkgame.objects.microObjects.Coordinates;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public abstract class PaneObject extends Pane implements NodeInterface
{
    public PaneObject(Coordinates coordinates)
    {
        super();
        innit(coordinates);
    }

    public PaneObject(Coordinates coordinates, Node... children)
    {
        super(children);
        innit(coordinates);
    }

    private void innit(Coordinates coordinates)
    {
        super.setLayoutX(coordinates.getX());
        super.setLayoutY(coordinates.getY());

        addNodeToList();
    }

    @Override
    public Coordinates getCoordinate()
    {
        return new Coordinates(super.getLayoutX(), super.getLayoutY());
    }

    @Override
    public char getCollisionDirection(NodeInterface other)
    {
        double thisX = this.getCoordinate().getX();
        double thisY = this.getCoordinate().getY();
        double otherX = other.getCoordinate().getX();
        double otherY = other.getCoordinate().getY();

        if(thisY == other.getTotalHeight() +1){
            if(thisX > otherX && thisX < other.getTotalWidth() || this.getTotalWidth() > otherX && this.getTotalWidth() < other.getTotalWidth() ) {
                return Compass.NORTH;
            }
        }
        if(this.getTotalWidth() == otherX - 1){
            if(thisY > otherY && thisY < other.getTotalHeight() || this.getTotalHeight() > otherY && this.getTotalHeight() < other.getTotalHeight() ) {
                return Compass.EAST;
            }
        }
        if(this.getTotalHeight() == otherY -1){
            if(thisX > otherX && thisX < other.getTotalWidth() || this.getTotalWidth() > otherX && this.getTotalWidth() < other.getTotalWidth() ) {
                return Compass.SOUTH;
            }
        }
        if(thisX == other.getTotalWidth() + 1){
            if(thisY > otherY && thisY < other.getTotalHeight() || this.getTotalHeight() > otherY && this.getTotalHeight() < other.getTotalHeight() ) {
                return Compass.WEST;
            }
        }
        return 0;
    }

    @Override
    public boolean hasCollision(NodeInterface other2dObject)
    {
        return getCollisionDirection(other2dObject) != 0;
    }

    @Override
    public boolean containsObject(NodeInterface nodeInterface)
    {
        Coordinates other = nodeInterface.getCenter();
        double thisX = this.getCoordinate().getX();
        double thisY = this.getCoordinate().getY();

        return other.getX() > thisX && other.getX() < this.getTotalWidth() && other.getY() > thisY && other.getY() < this.getTotalHeight();
    }

    @Override
    public abstract void addNodeToList();

    @Override
    public Coordinates getCenter()
    {
        double screenCenterX = this.getX() + (getWidth() / 2f);
        double screenCenterY = this.getY() + (getHeight() / 2f);
        return new Coordinates(screenCenterX, screenCenterY);
    }

    @Override
    public double getX()
    {
        return super.getLayoutX();
    }

    @Override
    public double getY()
    {
        return super.getLayoutY();
    }

    @Override
    public double getTotalWidth()
    {
        return this.getX() + getWidth();
    }

    @Override
    public double getTotalHeight()
    {
        return this.getY() + getHeight();
    }

    @Override
    public void setCoordinate(Coordinates coordinate)
    {
        this.setX(coordinate.getX());
        this.setY(coordinate.getY());
    }

    @Override
    public void setCoordinate(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void setX(double x)
    {
        super.setLayoutX(x);
    }

    @Override
    public void setY(double y)
    {
        super.setLayoutY(y);
    }
}
