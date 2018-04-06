package walkgame.interfaces;

import javafx.geometry.Point2D;

public interface MiniNodeInterface {
    Point2D getPoint2D();

    double getX();
    double getY();
    double getMaxX();
    double getMaxY();
    double getWidth();
    double getHeight();
    double getSceneHorizontalCenter();
    double getSceneVerticalCenter();
    Point2D getSceneCenter();

    void setX(double x);
    void setY(double y);
}
