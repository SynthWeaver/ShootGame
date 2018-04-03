package walkgame.views;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import walkgame.controllers.FirstViewMainController;
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

public class FirstMainView extends MainView
{
    public FirstViewMainController firstViewController;
    public Player player;
    public PlayerStatus playerStatusUI;

    public FirstMainView()
    {
        super();

        super.map = new Group(Room.group, Wall.group, Door.group);
        super.cast = new Group(Bullet.group, Enemy.group);
        super.fog = new Group(Fog.group);
        super.hud = new Group(Player.group, PlayerStatus.group);

        super.movableGroup = new MovableGroup(super.map, super.cast, super.fog);
        super.root = new Group(movableGroup, hud);
        this.createScene();

        firstViewController = new FirstViewMainController(this);

        this.createFloor();
        player = new Player(MainView.playerSpawn, "Jack", new Pistol());
        playerStatusUI = new PlayerStatus();
    }

    private void createFloor()
    {
        Image floorImage = new Image("walkgame/res/map/floor1.png");
        double spawnX = MainView.getScreenCenter().getX() - (floorImage.getWidth() / 2f);
        double spawnY = MainView.getScreenCenter().getY() - (floorImage.getHeight() / 2f);;
        new Room(floorImage, new Coordinates(spawnX, spawnY));
    }

    @Override
    protected void createScene()
    {
        super.createScene();

        super.scene.setOnKeyPressed(event -> {
            firstViewController.pressKeyButton(event.getCode());
        });

        super.scene.setOnKeyReleased(event -> {
            firstViewController.releaseKeyButton(event.getCode());
        });

        super.scene.setOnMousePressed(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
            {
                firstViewController.mouseClick(new Coordinates(event.getX(), event.getY()));
            }
        });

        super.scene.setOnMouseReleased(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
            {
                firstViewController.mouseRelease();
            }
        });

        super.scene.setOnMouseMoved(event -> {
            player.rotateImage(new Coordinates(event.getX(), event.getY()));
        });

        super.scene.setOnMouseDragged(event -> {
            player.rotateImage(new Coordinates(event.getX(), event.getY()));
        });
    }
}