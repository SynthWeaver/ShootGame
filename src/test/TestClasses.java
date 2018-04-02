package test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import walkgame.objects.hud.Player;
import walkgame.objects.map.Room;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.MovableGroup;
import walkgame.objects.microObjects.guns.Pistol;
import walkgame.views.parentClasses.MainView;

public class TestClasses {

    public Player player;
    public Room room;

    public void innit() {
        new JFXPanel();

        Group root = new Group(new MovableGroup(), new Group());
        MainView.addScene(new Scene(root));

        Player.group.getChildren().clear();
        Room.group.getChildren().clear();
        Room.lastVisitedRoom = null;

        player = new Player(MainView.playerSpawn, "Jack", new Pistol());
        room = new Room(new Image("walkgame/res/floor1.png"), new Coordinates(0,0));
    }
}
