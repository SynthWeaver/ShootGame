package walkgame.objects.parentClasses;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import walkgame.interfaces.ObjectInGame;

public abstract class ImageViewObject extends ImageView implements ObjectInGame
{
    public ImageViewObject(Point2D point2D)
    {
        super();
        innit(point2D);
    }

    public ImageViewObject(Image image, Point2D point2D)
    {
        super(image);
        innit(point2D);
    }

    private void innit(Point2D point2D)
    {
        super.setX(point2D.getX());
        super.setY(point2D.getY());

        addNodeToList();
    }

    @Override
    public Point2D getPoint2D()
    {
        Point2D point2D = new Point2D(this.getX(), this.getY());
        return point2D;
    }

    @Override
    public Point2D getMaxPoint2D()
    {
        Point2D point2D = new Point2D(this.getMaxX(), this.getMaxY());
        return point2D;
    }

    @Override
    public abstract void addNodeToList();

    @Override
    public double getMaxX()
    {
        return this.getX() + getWidth();
    }

    @Override
    public double getMaxY()
    {
        return this.getY() + getHeight();
    }

    @Override
    public double getWidth()
    {
        return this.getBoundsInParent().getWidth();
    }

    @Override
    public double getHeight()
    {
        return this.getBoundsInParent().getHeight();
    }

    @Override
    public Point2D getSize()
    {
        return new Point2D(this.getWidth(), this.getHeight());
    }

    @Override
    public double getSceneHorizontalCenter()
    {
        return getX() + (getWidth() / 2f);
    }

    @Override
    public double getSceneVerticalCenter()
    {
        return getY() + (getHeight() / 2f);
    }

    @Override
    public Point2D getCenter()
    {
        return new Point2D(getSceneHorizontalCenter(), getSceneVerticalCenter());
    }
}
