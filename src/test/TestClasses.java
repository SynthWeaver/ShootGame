package test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import walkgame.objects.cast.Enemy;
import walkgame.objects.cast.Fog;
import walkgame.objects.cast.bullets.Bullet;
import walkgame.objects.hud.Player;
import walkgame.objects.hud.PlayerStatus;
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

        Group map = new Group(Room.group, Door.group, Wall.group);
        Group cast = new Group(Bullet.group, Enemy.group);
        Group fog = new Group(Fog.group);
        Group hud = new Group(Player.group, PlayerStatus.group);

        Group movableGroup = new MovableGroup(map, cast, fog);
        Group root = new Group(movableGroup, hud);

        scene = new Scene(root);
        MainView.addScene(scene);

        room = new Room(new Coordinates(0,0));
        player = new Player(MainView.playerSpawn, "Jack", new Pistol());

    }
}
