package walkgame.controllers;

import walkgame.interfaces.Moveable;
import walkgame.objects.parentObjects.GameObject;

public abstract class Controller extends gameloop.Controller {
    @Override
    public void tick()
    {
        for(GameObject object : GameObject.gameObjectList)
        {
            if(object instanceof Moveable)
            {
                ((Moveable) object).move();
            }
        }
    }
}
