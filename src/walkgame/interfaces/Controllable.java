package walkgame.interfaces;

import javafx.geometry.Point2D;
import walkgame.objects.microObjects.Controlls;

public interface Controllable
{
    void checkButton(Controlls controlls);
    void rotateImage(Point2D mouseCoordinates);
}
