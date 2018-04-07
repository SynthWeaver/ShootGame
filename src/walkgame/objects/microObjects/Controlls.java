package walkgame.objects.microObjects;

import java.util.ArrayList;

public class Controlls {
    private ArrayList<Key> pressedButtons = new ArrayList<>();

    public static Key up = new Key('W');
    public static Key right = new Key('D');
    public static Key down = new Key('S');
    public static Key left = new Key('A');
    public static Key reload = new Key('R');//todo: reload werkt niet


    public void pressButton(Character keyPressed)
    {
        Key[] keyList = {up, left, down, right};

        for (Key key : keyList)
        {
            if(key.key.equals(keyPressed))
            {
                key.press();
                if(!pressedButtons.contains(key))
                {
                    pressedButtons.add(key);
                }
            }
        }
    }

    public void releaseButton(Character keyPressed)//todo: van schermwisselen verpest dit
    {
        Key[] keyList = {up, left, down, right};

        for (Key key : keyList)
        {
            if(key.key.equals(keyPressed))
            {
                key.release();
                if(pressedButtons.contains(key))
                {
                    pressedButtons.remove(key);
                }
            }
        }
    }

    public ArrayList<Key> getPressedButtons()
    {
        return pressedButtons;
    }

    @Deprecated
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
