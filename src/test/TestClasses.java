package test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import walkgame.objects.cast.bullets.Bullet;
import walkgame.objects.hud.Player;
import walkgame.objects.map.Door;
import walkgame.objects.map.Room;
import walkgame.objects.map.Wall;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.MovableGroup;
import walkgame.objects.microObjects.guns.Pistol;
import walkgame.views.parentClasses.MainView;

public class TestClasses {

    public Player player;
    public Room room;
    public Scene scene;

    public void innit() {
        new JFXPanel();

        Room.group.getChildren().clear();
        Room.lastVisitedRoom = null;
        Wall.group.getChildren().clear();
        Door.group.getChildren().clear();

        Bullet.group.getChildren().clear();

        Player.group.getChildren().clear();

        MainView.clearScenes();

        Group root = new Group(new MovableGroup(), new Group());
        scene = new Scene(root);
        MainView.addScene(scene);

        player = new Player(MainView.playerSpawn, "Jack", new Pistol());
        room = new Room(new Image("walkgame/res/map/floor1.png"), new Coordinates(0,0));
    }
}
