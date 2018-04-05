package walkgame.interfaces;

import walkgame.objects.microObjects.Controlls;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.Key;

public interface Controllable
{
    void checkButton(Controlls controlls);
    void pressButton(Key k);
    void releaseButton(Key k);
    void rotateImage(Coordinates mouseCoordinates);
}
