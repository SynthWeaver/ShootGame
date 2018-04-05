package walkgame.objects.parentClasses;

import javafx.geometry.Bounds;
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

    private Bounds getSceneBounds()
    {
        Bounds localBounds = this.getBoundsInLocal();
        return this.localToScene(localBounds);
    }

    @Override
    public double getSceneX()
    {
        return getSceneBounds().getMinX();
    }

    @Override
    public double getSceneY()
    {
        return getSceneBounds().getMinY();
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
    public Coordinates getCenter()
    {
        double screenCenterX = this.getCoordinate().getX() + (getWidth() / 2f);
        double screenCenterY = this.getCoordinate().getY() + (getHeight() / 2f);
        return new Coordinates(screenCenterX, screenCenterY);
    }

    @Override
    public double getWidth()
    {
        return getSceneBounds().getWidth();
    }

    @Override
    public double getHeight()
    {
        return getSceneBounds().getHeight();
    }

    @Override
    public double getSceneMaxX()
    {
        return  getSceneBounds().getMaxX();
    }

    @Override
    public double getSceneMaxY()
    {
        return getSceneBounds().getMaxY();
    }

    @Override
    public double getSceneHorizontalCenter()
    {
        return getSceneX() + (getWidth() / 2f);
    }

    @Override
    public double getSceneVerticalCenter()
    {
        return getSceneY() + (getHeight() / 2f);
    }

    @Override
    public boolean contains(double localX, double localY) {
        return this.contains(new Point2D(localX, localY));
    }

    @Override
    public boolean contains(Point2D localPoint) {
        return this.getSceneBounds().contains(localPoint);
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
