package walkgame.views;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import walkgame.controllers.FirstViewMainController;
import walkgame.objects.Floor;
import walkgame.objects.Player;
import walkgame.objects.guns.Pistol;
import walkgame.objects.microObjects.Coordinates;

public class FirstMainView extends MainView
{
    public FirstViewMainController firstViewController;
    public Player player;

    public FirstMainView(Stage primaryStage)
    {
        super(primaryStage);
        firstViewController = new FirstViewMainController(this);

        createFloor();
        player = new Player(MainView.playerSpawn, "Jack", new Pistol());
    }



    private void createFloor()
    {
        Image floorImage = new Image("walkgame/res/floor1.png");
        double spawnX = MainView.screenCenter.getX() - (floorImage.getWidth() / 2f);
        double spawnY = MainView.screenCenter.getY() - (floorImage.getHeight() / 2f);;

        new Floor(floorImage, new Coordinates(spawnX, spawnY));

        new Floor(floorImage, new Coordinates(Floor.floorList.get(0).getX() + floorImage.getWidth(), spawnY));
    }


    @Override
    protected void createScene()
    {
        super.createScene();

        scene.setOnKeyPressed(event -> {
            firstViewController.pressKeyButton(event.getCode());
        });

        scene.setOnKeyReleased(event -> {
            firstViewController.releaseKeyButton(event.getCode());
        });

        scene.setOnMousePressed(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
            {
                firstViewController.mouseClick(new Coordinates(event.getX(), event.getY()));
            }
        });

        scene.setOnMouseReleased(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
            {
                firstViewController.mouseRelease();
            }
        });

        scene.setOnMouseMoved(event -> {
            player.rotateImage(new Coordinates(event.getX(), event.getY()));
        });
        
        scene.setOnMouseDragged(event -> {
            player.rotateImage(new Coordinates(event.getX(), event.getY()));
        });
    }
}