package walkgame.controllers;


import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import walkgame.controllers.parentClasses.MainController;
import walkgame.interfaces.Controllable;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;
import walkgame.objects.map.Room;
import walkgame.objects.microObjects.Coordinates;
import walkgame.views.FirstMainView;
import walkgame.views.parentClasses.MainView;

import java.util.ArrayList;
import java.util.LinkedList;

public class FirstViewMainController extends MainController {

    public FirstMainView firstView;
    public FirstViewMainController(FirstMainView firstView) {
        this.firstView = firstView;
    }



    public void pressKeyButton(KeyCode k)
    {
        MainView.getMovableGroup().pressButton(k);

        for(Node node : MainView.getListOfAllNodes())
        {
            if (node instanceof Controllable)
            {
                ((Controllable) node).pressButton(k);
            }
        }
    }

    public void releaseKeyButton(KeyCode k)
    {
        MainView.getMovableGroup().releaseButton(k);

        for(Node node : MainView.getListOfAllNodes())
        {
            if (node instanceof Controllable)
            {
                ((Controllable) node).releaseButton(k);
            }
        }
    }

    public void mouseClick(Coordinates mouseCoordinates)
    {
        Coordinates screenCenter = MainView.getScreenCenter().getRelativisedHudCoordinate();
        firstView.player.getCurrentGun().shoot(screenCenter, mouseCoordinates.getRelativisedHudCoordinate());
    }

    public void mouseRelease()
    {
       firstView.player.getCurrentGun().releaseTrigger();
    }

    @Override
    public void tick()//todo: set content to render method for performance boost
    {
        MainView.getMovableGroup().move();

        for(Node node : MainView.getListOfAllNodes())
        {
            LinkedList<Destructible> toDestroy = new LinkedList<>();
            if(node instanceof Moveable)
            {
                Moveable moveable = ((Moveable) node);
                moveable.move();
            }
            if(node instanceof Destructible)
            {
                Destructible destructible = (Destructible) node;
                if(destructible.getHealth().get() <= 0)
                {
                    toDestroy.add(destructible);
                }
            }

            for(Destructible destructible : toDestroy)//after the loop, delete all destructibles
            {
                MainView.getRoot().remove(destructible);
                destructible.destroy();
            }
        }

        //check if player is in room
        ArrayList<Node> floorList = new ArrayList<>(Room.group.getChildren());
        for(Node node : floorList)
        {
            Room room = (Room) node;

            if(room.contains(firstView.player.getPoint2D()) && !Room.lastVisitedRoom.equals(room))
            {
                room.enterRoom();
            }
        }
    }
}