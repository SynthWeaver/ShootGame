package walkgame.objects.parentClasses;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import walkgame.interfaces.ObjectInGame;

public abstract class PaneObject extends Pane implements ObjectInGame
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
    public Point2D getMaxPoint2D() {
        Point2D point2D = new  Point2D(this.getMaxX(), this.getMaxY());
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
    public Point2D getSize()
    {
        return new Point2D(super.getWidth(), super.getHeight());
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

    @Override
    public Image getImage() {
        return null;//todo: moet nog gefixt worden
    }
}
