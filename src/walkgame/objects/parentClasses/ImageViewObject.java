package walkgame.objects.parentClasses;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import walkgame.interfaces.NodeInterface;
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
    public Point2D getPoint2D()
    {
        Point2D point2D = new  Point2D(this.getX(), this.getY());
        return point2D;
    }

    @Override
    public abstract boolean isSolid();

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
        return this.getX() + getWidth();
    }

    @Override
    public double getTotalHeight()
    {
        return this.getY() + getHeight();
    }

    @Override
    public double getHorizontalCenter()
    {
        return getX() + (getWidth() / 2f);
    }

    @Override
    public double getVerticalCenter()
    {
        return getY() + (getHeight() / 2f);
    }

    @Override
    public void setCoordinate(Coordinates coordinate)
    {
        this.setX(coordinate.getX());
        this.setY(coordinate.getY());
    }

    @Override
    public void setCoordinate(double x, double y)
    {
        this.setX(x);
        this.setY(y);
    }
}
