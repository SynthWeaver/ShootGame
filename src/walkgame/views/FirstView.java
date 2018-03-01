package walkgame.views;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import walkgame.controllers.FirstViewController;
import walkgame.interfaces.Moveable;
import walkgame.objects.Floor;
import walkgame.objects.Player;
import walkgame.objects.guns.Pistol;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentObjects.GameObject;

public class FirstView extends View
{
    private FirstViewController firstViewController;
    public Player player;

    private Group root;
    public Scene scene;
    private Stage primaryStage;

    private static Coordinates screenSize = new Coordinates(300, 300);
    private Coordinates gameSize = new Coordinates(400, 400);
    public static Coordinates screenCenter = new Coordinates(screenSize.getX() / 2f, screenSize.getY() / 2f);
    private static Coordinates playerSpawn = new Coordinates(screenCenter.getX() - (Player.PLAYER_SIZE.getX() / 2f) , screenCenter.getY() - (Player.PLAYER_SIZE.getY() / 2f));

    public FirstView(Stage primaryStage)
    {
        firstViewController = new FirstViewController(this);

        root = new Group(); //createRoot();
        createFloor();
        player = new Player(playerSpawn, "Jack", new Pistol());

        createScene();

        this.primaryStage = primaryStage;
    }



    @Override
    public void render()
    {
        updateRoot();
    }



    private void createFloor()
    {
        Image floorImage = new Image("walkgame/res/floor1.png");
        double spawnX = FirstView.screenCenter.getX() - (floorImage.getWidth() / 2f);
        double spawnY = FirstView.screenCenter.getY() - (floorImage.getHeight() / 2f);;

        new Floor(floorImage, new Coordinates(spawnX, spawnY));

        new Floor(floorImage, new Coordinates(Floor.floorList.get(0).getX() + floorImage.getWidth(), spawnY));
    }

    @Override
    protected void updateRoot()
    {
        for(GameObject gameObject : GameObject.gameObjectList)
        {
            if(!root.getChildren().contains(gameObject))
            {
                root.getChildren().add(gameObject);
            }
        }
    }

    @Override
    protected void createScene()
    {
        scene = new Scene(root, FirstView.screenSize.getX(), FirstView.screenSize.getY(), Color.BLACK);

        scene.setOnKeyPressed(event -> {
            KeyCode k = event.getCode();
            if(k == KeyCode.W || k == KeyCode.D || k == KeyCode.S || k == KeyCode.A)
            {
                firstViewController.pressButton(k);
            }
        });

        scene.setOnKeyReleased(event -> {
            KeyCode k = event.getCode();
            if(k == KeyCode.W || k == KeyCode.D || k == KeyCode.S || k == KeyCode.A)
            {
                firstViewController.releaseButton(k);
            }
        });

        scene.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
            {
                firstViewController.mouseClick(new Coordinates(event.getX(), event.getY()));
            }
        });

        scene.setOnMouseMoved(event -> {
            player.rotateImage(new Coordinates(event.getX(), event.getY()));
        });
    }
}