package walkgame.controllers;


import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import walkgame.controllers.parentClasses.MainController;
import walkgame.interfaces.Controllable;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;
import walkgame.interfaces.Shootable;
import walkgame.objects.hud.Hud;
import walkgame.objects.hud.Player;
import walkgame.objects.map.Room;
import walkgame.objects.microObjects.Controlls;
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

    public void mouseClick(Point2D mouseCoordinates)
    {
        Player player = MainView.getCurrentPlayer();//todo: scene coordinates

        Point2D relativePlayerCenter =  Hud.hudToMovableGroup(player.getSceneCenter());
        Point2D relativeMouseCoordinates = Hud.hudToMovableGroup(mouseCoordinates);

        firstView.player.getCurrentGun().shoot(relativePlayerCenter, relativeMouseCoordinates);
    }

    public void mouseRelease()
    {
       firstView.player.getCurrentGun().releaseTrigger();
    }

    @Override
    public void tick()//todo: set content to render method for performance boost
    {
        checkButtons();
        moveNotes();
        playerEnterRoom();
        destroyNodes();
    }

    @Override
    public void render() {

    }

    private void checkButtons() {
        for(Controllable controllable : MainView.CONTROLLABLE_LIST)
        {
            controllable.checkButton(controlls);
        }
    }

    private void moveNotes() {
        for(Moveable moveable : MainView.MOVEABLE_LIST)
        {
            moveable.move();
        }
    }

    private void playerEnterRoom() {
        for(Node node : Room.group.getChildren()) {
            Room room = (Room) node;
            Player player = firstView.player;

            Point2D relativePlayerCenter = Hud.hudToMovableGroup(player.getSceneCenter().subtract(0.5, 0.5));

            if(room.contains(relativePlayerCenter))
            {
                if(!Room.lastVisitedRoom.equals(room)) {
                    room.enterRoom();
                    player.currentRoom = room;
                    break;
                }
            }
        }
    }

    private void destroyNodes() {
        LinkedList<Destructible> DestroyList = new LinkedList<>();

        for(Destructible destructible : MainView.DESTRUCTIBLE_LIST)
        {
            if(destructible.getHealth().get() <= 0)
            {
                DestroyList.add(destructible);
            }
        }

        for(Destructible destructible : DestroyList)//after the loop, delete all destructibles
        {
            MainView.getRoot().remove(destructible);
            destructible.destroy();

            if(destructible instanceof Controllable)
            {
                MainView.CONTROLLABLE_LIST.remove(destructible);
            }

            MainView.DESTRUCTIBLE_LIST.remove(destructible);

            if(destructible instanceof Moveable)
            {
                MainView.MOVEABLE_LIST.remove(destructible);
            }
            if(destructible instanceof Shootable)
            {
                MainView.SHOOTABLE_LIST.remove(destructible);
            }

            System.out.println(String.format("Object %s has been destroyed", destructible));
        }
    }
}