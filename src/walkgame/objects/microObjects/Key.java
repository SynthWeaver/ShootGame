package walkgame.objects.microObjects;

public class Key {
    public Character key;
    public boolean isPressed;

    public Key(Character key) {
        this.key = key;
        isPressed = false;
    }

    public void press() {
        isPressed = true;
    }
    public void release() {
        isPressed = false;
    }
}
