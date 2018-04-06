package walkgame.interfaces;

public interface Moveable
{
    void move();
    void rotateImage();

    void setSpeed(double speed);

    void setVelocityX(double velocity);
    void setVelocityY(double velocity);

    void setX(double x);
    void setY(double y);

    double getSpeed();

    double getVelocityX();
    double getVelocityY();

    double getX();
    double getY();
}
