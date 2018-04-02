package walkgame.objects.parentClasses;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import walkgame.interfaces.NodeInterface;
import walkgame.objects.microObjects.Compass;
import walkgame.objects.microObjects.Coordinates;

public abstract class ImageViewObject extends ImageView implements NodeInterface
{
    public ImageViewObject(Coordinates coordinates)
    {
        super();
        innit(coordinates);
    }

    public ImageViewObject(Image image, Coordinates coordinates)
    {
        super(image);
        innit(coordinates);
    }

    private void innit(Coordinates coordinates)
    {
        super.setX(coordinates.getX());
        super.setY(coordinates.getY());

        addNodeToList();
    }

    @Override
    public Coordinates getCoordinate()
    {
        return new Coordinates(getX(), getY());
    }

    @Override
    public char getCollisionDirection(NodeInterface otherObject)//todo: n en z of w en e gaan beiden af als je door een deur loopt (tick struggle 60x ps)
    {
        double thisX = this.getCoordinate().getX();
        double thisY = this.getCoordinate().getY();
        double otherX = otherObject.getCoordinate().getX();
        double otherY = otherObject.getCoordinate().getY();

        if (thisY <= otherObject.getTotalHeight() &&  thisY >= otherY &&  thisX >= otherX && this.getTotalWidth() <= otherObject.getTotalWidth()) return Compass.NORTH;
        if (this.getTotalWidth() >= otherX && this.getTotalWidth() <= otherObject.getTotalWidth() &&  thisY >= otherY && this.getTotalHeight() <= otherObject.getTotalHeight()) return Compass.EAST;
        if (this.getTotalHeight() >= otherY && this.getTotalHeight() <= otherObject.getTotalHeight() &&  thisX >= otherX && this.getTotalWidth() <= otherObject.getTotalWidth()) return Compass.SOUTH;
        if (thisX <= otherObject.getTotalWidth() &&  thisX >= otherX &&  thisY >= otherY && this.getTotalHeight() <= otherObject.getTotalHeight()) return Compass.WEST;
        return 0;
    }

    @Override
    public boolean hasCollision(NodeInterface other2dObject)
    {
        return getCollisionDirection(other2dObject) != 0;
    }

    /*** @return true if parameter object is overlaps this object */
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
        double screenCenterX = this.getCoordinate().getX() + (getWidth() / 2f);
        double screenCenterY = this.getCoordinate().getY() + (getHeight() / 2f);
        return new Coordinates(screenCenterX, screenCenterY);
    }

    @Override
    public double getWidth()
    {
        return super.getImage().getWidth();
    }

    @Override
    public double getHeight()
    {
        return super.getImage().getHeight();
    }

    @Override
    public double getTotalWidth()
    {
        return this.getCoordinate().getX() + getWidth();
    }

    @Override
    public double getTotalHeight()
    {
        return this.getCoordinate().getY() + getHeight();
    }

    @Override
    public void setCoordinate(Coordinates coordinate)
    {
        this.setX(coordinate.getX());
        this.setY(coordinate.getY());
    }
}
