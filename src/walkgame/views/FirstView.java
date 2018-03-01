package walkgame.views;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import walkgame.controllers.FirstViewController;
import walkgame.objects.Floor;
import walkgame.objects.Player;
import walkgame.objects.guns.Pistol;
import walkgame.objects.microObjects.Coordinates;

public class FirstView extends View
{
    public FirstViewController firstViewController;
    public Player player;

    public FirstView(Stage primaryStage)
    {
        super(primaryStage);
        firstViewController = new FirstViewController(this);

        createFloor();
        player = new Player(playerSpawn, "Jack", new Pistol());
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
    protected void createScene()
    {
        super.createScene();

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