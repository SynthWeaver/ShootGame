package walkgame.controllers;


import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import walkgame.controllers.parentClasses.MainController;
import walkgame.interfaces.Controllable;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;
import walkgame.objects.map.Room;
import walkgame.objects.microObjects.Controlls;
import walkgame.objects.microObjects.Coordinates;
import walkgame.views.FirstMainView;
import walkgame.views.parentClasses.MainView;

import java.util.LinkedList;

public class FirstViewMainController extends MainController {

    private Controlls controlls = new Controlls();
    public FirstMainView firstView;
    public FirstViewMainController(FirstMainView firstView) {
        this.firstView = firstView;
    }



    public void pressKeyButton(KeyCode k)
    {
        controlls.pressButton((char) k.getCode());
    }

    public void releaseKeyButton(KeyCode k)
    {
        controlls.releaseButton((char) k.getCode());
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
        LinkedList<Destructible> toDestroy = new LinkedList<>();
        for(Node node : MainView.getListOfAllNodes())
        {
            checkButtons(node);

            moveNotes(node);

            playerEnterRoom(node);

            destroyNodes(node, toDestroy);
        }

        for(Destructible destructible : toDestroy)//after the loop, delete all destructibles
        {
            MainView.getRoot().remove(destructible);
            destructible.destroy();
        }
    }

    @Override
    public void render() {

    }

    private void checkButtons(Node node) {
        if (node instanceof Controllable)
        {
            ((Controllable) node).checkButton(controlls);
        }
    }

    private void moveNotes(Node node) {
        if(node instanceof Moveable)
        {
            Moveable moveable = ((Moveable) node);
            moveable.move();
        }
    }

    private void playerEnterRoom(Node node) {
        if(node instanceof Room) {
            Room room = (Room) node;

            if (room.contains(firstView.player.getPoint2D()) && !Room.lastVisitedRoom.equals(room)) {
                room.enterRoom();
            }
        }
    }

    private void destroyNodes(Node node, LinkedList<Destructible> toDestroy) {
        if(node instanceof Destructible)
        {
            Destructible destructible = (Destructible) node;
            if(destructible.getHealth().get() <= 0)
            {
                toDestroy.add(destructible);
            }
        }
    }
}