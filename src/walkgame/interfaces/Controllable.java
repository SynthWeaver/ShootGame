package walkgame.interfaces;

import walkgame.objects.microObjects.Controlls;
import walkgame.objects.microObjects.Coordinates;

public interface Controllable
{
    void checkButton(Controlls controlls);
    void rotateImage(Coordinates mouseCoordinates);
}
