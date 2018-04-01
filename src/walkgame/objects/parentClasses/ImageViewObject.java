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
    public char getCollisionDirection(NodeInterface otherObject)
    {
        if (super.getY() <= otherObject.getTotalHeight() && super.getY() >= otherObject.getY() && super.getX() >= otherObject.getX() && this.getTotalWidth() <= otherObject.getTotalWidth()) return Compass.NORTH;
        if (this.getTotalWidth() >= otherObject.getX() && this.getTotalWidth() <= otherObject.getTotalWidth() && super.getY() >= otherObject.getY() && this.getTotalHeight() <= otherObject.getTotalHeight()) return Compass.EAST;
        if (this.getTotalHeight() >= otherObject.getY() && this.getTotalHeight() <= otherObject.getTotalHeight() && super.getX() >= otherObject.getX() && this.getTotalWidth() <= otherObject.getTotalWidth()) return Compass.SOUTH;
        if (super.getX() <= otherObject.getTotalWidth() && super.getX() >= otherObject.getX() && super.getY() >= otherObject.getY() && this.getTotalHeight() <= otherObject.getTotalHeight()) return Compass.WEST;
        return 0;
    }

    @Override
    public boolean hasCollision(NodeInterface other2dObject)
    {
        return getCollisionDirection(other2dObject) != 0;
    }

    @Override
    public abstract void addNodeToList();

    @Override
    public Coordinates getCenter()
    {
        double screenCenterX = super.getX() + (getWidth() / 2f);
        double screenCenterY = super.getY() + (getHeight() / 2f);
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
        return super.getX() + getWidth();
    }

    @Override
    public double getTotalHeight()
    {
        return super.getY() + getHeight();
    }

    @Override
    public void setCoordinate(Coordinates coordinate)
    {
        this.setX(coordinate.getX());
        this.setY(coordinate.getY());
    }
}
