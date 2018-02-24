package walkgame.views;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import walkgame.controllers.FirstController;
import walkgame.objects.Floor;
import walkgame.objects.Player;
import walkgame.objects.guns.Pistol;
import walkgame.objects.microObjects.Coordinates;

public class FirstView extends View
{
    private FirstController firstController;
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
        firstController = new FirstController(this);
        player = new Player(playerSpawn, "Jack", new Pistol());

        createFloor();
        createRoot();
        createScene();

        this.primaryStage = primaryStage;
    }



    @Override
    public void render()
    {

    }



    private void createFloor()
    {
        new Floor(player.getCoordinate(), new Image("walkgame/res/floor1.png"));

        new Floor(new Coordinates(Floor.floorList.get(0).getX() + new Image("walkgame/res/floor1.png").getWidth(), player.getY()), new Image("walkgame/res/floor1.png"));
    }

    @Override
    protected void createRoot()
    {
        Pane map = new Pane();
        for (Floor f : Floor.floorList) {
            map.getChildren().add(f);
        }

        map.setMinSize(gameSize.getX(), gameSize.getY());
        root = new Group(map, player);
    }

    @Override
    protected void createScene()
    {
        scene = new Scene(root, FirstView.screenSize.getX(), FirstView.screenSize.getY(), Color.BLACK);

        scene.setOnKeyPressed(event -> {
            KeyCode k = event.getCode();
            if(k == KeyCode.W || k == KeyCode.D || k == KeyCode.S || k == KeyCode.A)
            {
                firstController.pressButton(k);
            }
        });

        scene.setOnKeyReleased(event -> {
            KeyCode k = event.getCode();
            if(k == KeyCode.W || k == KeyCode.D || k == KeyCode.S || k == KeyCode.A)
            {
                firstController.releaseButton(k);
            }
        });

        scene.setOnMouseClicked(event -> {
            MouseButton mouseButton = event.getButton();
            if(mouseButton == MouseButton.PRIMARY)
            {
                firstController.mouseClick();
            }
        });

        scene.setOnMouseMoved(event -> {
            player.rotateImage(new Coordinates(event.getX(), event.getY()));
        });
    }
}