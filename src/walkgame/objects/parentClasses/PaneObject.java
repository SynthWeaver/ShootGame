package walkgame.objects.parentClasses;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import walkgame.interfaces.NodeInterface;

public abstract class PaneObject extends Pane implements NodeInterface
{
    public PaneObject(Point2D coordinates)
    {
        super();
        innit(coordinates);
    }

    public PaneObject(Point2D coordinates, Node... children)
    {
        super(children);
        innit(coordinates);
    }

    private void innit(Point2D coordinates)
    {
        super.setLayoutX(coordinates.getX());
        super.setLayoutY(coordinates.getY());

        addNodeToList();
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
    public double getMaxX()
    {
        return this.getX() + getWidth();
    }

    @Override
    public double getMaxY()
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
    public Point2D getSceneCenter()
    {
        return new Point2D(getSceneHorizontalCenter(), getSceneVerticalCenter());
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
