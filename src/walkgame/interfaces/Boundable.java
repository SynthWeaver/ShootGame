package walkgame.interfaces;

import javafx.geometry.Point2D;

public interface Boundable {
    Point2D getPoint2D();
    Point2D getMaxPoint2D();

    double getX();
    double getY();
    double getMaxX();
    double getMaxY();
    double getWidth();
    double getHeight();
    Point2D getSize();
    double getSceneHorizontalCenter();
    double getSceneVerticalCenter();
    Point2D getCenter();

    void setX(double x);
    void setY(double y);
}
