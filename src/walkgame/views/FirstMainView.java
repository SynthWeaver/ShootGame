package walkgame.views;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import walkgame.controllers.FirstViewMainController;
import walkgame.objects.cast.Enemy;
import walkgame.objects.cast.bullets.Bullet;
import walkgame.objects.hud.Hud;
import walkgame.objects.hud.Player;
import walkgame.objects.hud.PlayerStatus;
import walkgame.objects.map.Floor;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.Map;
import walkgame.objects.microObjects.guns.Pistol;
import walkgame.views.parentClasses.MainView;

public class FirstMainView extends MainView
{
    public FirstViewMainController firstViewController;
    public Player player;
    public PlayerStatus playerStatusUI;

    public FirstMainView(Stage primaryStage)
    {
        super(primaryStage);

        super.map = new Map(Floor.group);
        super.cast = new Group(Bullet.group, Enemy.group);//todo: make dit lid van controllable interface zodat bullet beweegt met lopen
        super.hud = Hud.group;

        super.root = new Group(map, cast, hud);
        this.createScene();

        firstViewController = new FirstViewMainController(this);

        this.createFloor();
        player = new Player(MainView.playerSpawn, "Jack", new Pistol());
        playerStatusUI = new PlayerStatus(player);
    }

    private void createFloor()
    {
        Image floorImage = new Image("walkgame/res/floor1.png");
        double spawnX = MainView.screenCenter.getX() - (floorImage.getWidth() / 2f);
        double spawnY = MainView.screenCenter.getY() - (floorImage.getHeight() / 2f);;

        new Floor(floorImage, new Coordinates(spawnX, spawnY));

        new Floor(floorImage, new Coordinates(Floor.group.getChildren().get(0).getLayoutX() + floorImage.getWidth(), spawnY));
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