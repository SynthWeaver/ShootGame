package walkgame.interfaces;

import javafx.scene.input.KeyCode;

public interface Controllable
{
    void pressButton(KeyCode c);
    void releaseButton(KeyCode c);
}
