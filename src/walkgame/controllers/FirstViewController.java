package walkgame.controllers;


import gameloop.GameLoop;
import javafx.scene.input.KeyCode;
import walkgame.interfaces.Moveable;
import walkgame.objects.bullets.Bullet;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentObjects.GameObject;
import walkgame.views.FirstView;
import walkgame.objects.Floor;

public class FirstViewController extends Controller{

    FirstView firstView;

    public FirstViewController(FirstView firstView) {
        this.firstView = firstView;
        new GameLoop(this).start();
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

    @Override
    public void render()
    {
        firstView.render();
    }
}
