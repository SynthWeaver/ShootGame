package walkgame.controllers;


import javafx.scene.input.KeyCode;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;
import walkgame.objects.Floor;
import walkgame.objects.Player;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentObjects.GameObject;
import walkgame.views.FirstMainView;
import walkgame.views.MainView;

public class FirstViewMainController extends MainController {

    FirstMainView firstView;

    public FirstViewMainController(FirstMainView firstView) {
        this.firstView = firstView;
    }



    public void pressButton(KeyCode k)
    {
        firstView.player.pressButton(k);
        for(Floor f : Floor.floorList)
        {
            f.pressButton(k);
        }
    }

    public void releaseButton(KeyCode k)
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
        for(GameObject object : GameObject.gameObjectList)
        {
            if(object instanceof Moveable)
            {
                ((Moveable) object).move();
            }
            if(object instanceof Destructible)
            {
                if(((Destructible) object).getHealth() <= 0)
                {
                    firstView.root.getChildren().remove(object);
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
