package walkgame.interfaces;

public interface Moveable extends Boundable
{
    void move();
    void rotateImage();

    void setSpeed(double speed);

    void setVelocityX(double velocity);
    void setVelocityY(double velocity);

    double getSpeed();

    double getVelocityX();
    double getVelocityY();

}
