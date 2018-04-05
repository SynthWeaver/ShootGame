package walkgame.objects.parentClasses;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import walkgame.interfaces.NodeInterface;
import walkgame.objects.microObjects.Coordinates;

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
    public Point2D getPoint2D()
    {
        Point2D point2D = new  Point2D(this.getX(), this.getY());
        return point2D;
    }

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
    public double getSceneMaxX()
    {
        return this.getX() + getWidth();
    }

    @Override
    public double getSceneMaxY()
    {
        return this.getY() + getHeight();
    }

    @Override
    public double getTotalWidth()
    {
        return this.getX() + getWidth();
    }

    @Override
    public double getTotalHeight()
    {
        return this.getX() + getHeight();
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
