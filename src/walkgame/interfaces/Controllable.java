package walkgame.interfaces;

import javafx.scene.input.KeyCode;
import walkgame.objects.microObjects.Coordinates;

public interface Controllable
{
    void pressButton(KeyCode k);
    void releaseButton(KeyCode k);
    void rotateImage(Coordinates mouseCoordinates);
}
