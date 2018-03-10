package walkgame.controllers;


import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import walkgame.controllers.parentClasses.MainController;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;
import walkgame.objects.Floor;
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
        firstView.player.pressButton(k);//todo: hier een forloop bouwen van root
        for(Floor f : Floor.floorList)
        {
            f.pressButton(k);
        }
    }

    public void releaseKeyButton(KeyCode k)
    {
        firstView.player.releaseButton(k);
        for(Floor f : Floor.floorList)
        {
            f.releaseButton(k);
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
        for(Node object : MainView.currentMap)
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
        firstView.render();
    }
}
