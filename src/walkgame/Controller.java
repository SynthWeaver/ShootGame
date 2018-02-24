package walkgame;


import gameloop.GameLoop;
import javafx.scene.input.KeyCode;
import walkgame.objects.Floor;

public class Controller extends gameloop.Controller{

    View view;

    public Controller(View view) {
        this.view = view;
        new GameLoop(this).start();
    }



    public void pressButton(KeyCode k)
    {
        GameLoop.logicUpdate = true;
        view.player.pressButton(k);
        for(Floor f : Floor.floorList)
        {
            f.pressButton(k);
        }
    }

    public void releaseButton(KeyCode k)
    {
        view.player.releaseButton(k);
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
        view.player.move();
        for (Floor floor : Floor.floorList)
        {
            floor.move();
        }
    }

    @Override
    public void render()
    {
        view.render();
    }
}
