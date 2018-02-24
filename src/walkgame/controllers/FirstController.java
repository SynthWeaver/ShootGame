package walkgame.controllers;


import gameloop.GameLoop;
import javafx.scene.input.KeyCode;
import walkgame.views.FirstView;
import walkgame.objects.Floor;

public class FirstController extends Controller{

    FirstView firstView;

    public FirstController(FirstView firstView) {
        this.firstView = firstView;
        new GameLoop(this).start();
    }



    public void pressButton(KeyCode k)
    {
        GameLoop.logicUpdate = true;
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

    public void mouseClick()
    {

    }



    @Override
    public void tick()
    {
        firstView.player.move();
        for (Floor floor : Floor.floorList)
        {
            floor.move();
        }
    }

    @Override
    public void render()
    {
        firstView.render();
    }
}
