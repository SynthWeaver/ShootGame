package walkgame.controllers;


import javafx.scene.input.KeyCode;
import walkgame.objects.Floor;
import walkgame.objects.microObjects.Coordinates;
import walkgame.views.FirstView;

public class FirstViewController extends Controller{

    FirstView firstView;

    public FirstViewController(FirstView firstView) {
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
        firstView.player.shoot(mouseCoordinates);
    }

    @Override
    public void render()
    {
        firstView.render();
    }
}
