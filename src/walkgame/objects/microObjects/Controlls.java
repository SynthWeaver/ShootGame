package walkgame.objects.microObjects;

import java.util.ArrayList;

public class Controlls {
    public static Key up = new Key('W');
    public static Key right = new Key('D');
    public static Key down = new Key('S');
    public static Key left = new Key('A');
    public static Key reload = new Key('R');

    public void pressButton(Character keyPressed)
    {
        Key[] keyList = {up, left, down, right};

        for (Key aKey : keyList)
        {
            if(aKey.key.equals(keyPressed))
            {
                aKey.press();
            }
        }
    }

    public void releaseButton(Character keyPressed)
    {
        Key[] keyList = {up, left, down, right};

        for (Key aKey : keyList)
        {
            if(aKey.key.equals(keyPressed))
            {
                aKey.release();
            }
        }
    }

    public ArrayList<Key> getPressedButtons()
    {
        ArrayList<Key> pressedButtons = new ArrayList<>();
        Key[] keyList = {up, left, down, right};
        for (Key key : keyList)
        {
            if (key.isPressed)
            {
                pressedButtons.add(key);
            }
        }
        return pressedButtons;
    }

    public ArrayList<Key> getReleasedButtons()
    {
        ArrayList<Key> releasedButtons = new ArrayList<>();
        Key[] keyList = {up, left, down, right};
        for (Key key : keyList)
        {
            if (!key.isPressed)
            {
                releasedButtons.add(key);
            }
        }
        return releasedButtons;
    }
}
