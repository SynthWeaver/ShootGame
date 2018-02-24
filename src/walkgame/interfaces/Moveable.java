package walkgame.interfaces;

public interface Moveable
{
    void move();
    void rotateImage();

    void setSpeed(double speed);
    double getSpeed();

    void setVelocityX(double velocity);
    void setVelocityY(double velocity);

    void setX(double x);
    void setY(double y);

    double getX();
    double getY();


}
