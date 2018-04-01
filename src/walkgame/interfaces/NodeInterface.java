package walkgame.interfaces;


import walkgame.objects.microObjects.Coordinates;

public interface NodeInterface
{
    char getCollisionDirection(NodeInterface otherObject);
    boolean hasCollision(NodeInterface other2dObject);
    void addNodeToList();

    Coordinates getCoordinate();
    Coordinates getCenter();

    double getX();
    double getY();
    double getWidth();
    double getHeight();
    double getTotalWidth();
    double getTotalHeight();

    void setCoordinate(Coordinates coordinate);
    void setX(double x);
    void setY(double y);


}
