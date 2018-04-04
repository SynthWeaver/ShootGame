package walkgame.objects.parentClasses;

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
        return getPoint2D(0, 0);
    }

    @Override
    public Point2D getPoint2D(double x, double y)
    {
        Point2D point2D = new  Point2D(this.getX() + x, this.getY() + y);
        point2D.add(this.getTotalWidth() + x, this.getTotalHeight() + y);
        return point2D;
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
