package walkgame.interfaces;


import javafx.geometry.Point2D;
import walkgame.objects.microObjects.Coordinates;

public interface NodeInterface
{
    Point2D getPoint2D();
    boolean isSolid();
    void addNodeToList();

    Coordinates getCoordinate();
    Coordinates getCenter();

    double getX();
    double getY();
    double getWidth();
    double getHeight();
    double getTotalWidth();
    double getTotalHeight();
    double getHorizontalCenter();
    double getVerticalCenter();

    void setCoordinate(Coordinates coordinate);
    void setCoordinate(double x, double y);
    void setX(double x);
    void setY(double y);
}
