package walkgame.controllers;


import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import walkgame.controllers.parentClasses.MainController;
import walkgame.interfaces.Controllable;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;
import walkgame.objects.microObjects.Coordinates;
import walkgame.views.FirstMainView;
import walkgame.views.parentClasses.MainView;

public class FirstViewMainController extends MainController {

    FirstMainView firstView;

    public FirstViewMainController(FirstMainView firstView) {
        this.firstView = firstView;
    }



    public void pressKeyButton(KeyCode k)
    {
        for(Node node : firstView.root)
        {
            if(node instanceof Controllable)
            {
                ((Controllable) node).pressButton(k);
            }
        }
    }

    public void releaseKeyButton(KeyCode k)
    {
        for(Node node : firstView.root)
        {
            if(node instanceof Controllable)
            {
                ((Controllable) node).releaseButton(k);
            }
        }
    }

    public void mouseClick(Coordinates mouseCoordinates)
    {
        firstView.player.getCurrentGun().shoot(MainView.screenCenter, mouseCoordinates);
    }

    public void mouseRelease()
    {
       firstView.player.getCurrentGun().releaseTrigger();
    }

    @Override
    public void tick()
    {
        MainView.map.move();

        for(Node object : MainView.currentMapList)
        {
            if(object instanceof Moveable)
            {
                ((Moveable) object).move();
            }
            if(object instanceof Destructible)
            {
                if(((Destructible) object).getHealth() <= 0)
                {
                    firstView.root.remove(object);
                    ((Destructible) object).destroy();
                    break;
                }
            }
        }
    }

    @Override
    public void render()
    {
        return;
    }
}
