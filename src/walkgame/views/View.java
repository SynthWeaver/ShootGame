package walkgame.views;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import walkgame.objects.Player;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentObjects.GameObject;

public abstract class View extends gameloop.View {

    private Group root;
    public Scene scene;
    private Stage primaryStage;

    protected static Coordinates screenSize = new Coordinates(300, 300);
    public Coordinates gameSize = new Coordinates(400, 400);
    public static Coordinates screenCenter = new Coordinates(screenSize.getX() / 2f, screenSize.getY() / 2f);
    protected static Coordinates playerSpawn = new Coordinates(screenCenter.getX() - (Player.PLAYER_SIZE.getX() / 2f) , screenCenter.getY() - (Player.PLAYER_SIZE.getY() / 2f));

    public View(Stage primaryStage) {
        root = new Group();

        this.primaryStage = primaryStage;
        createScene();
    }

    @Override
    public void render()
    {
        updateRoot();
    }

    private void updateRoot()
    {
        for(GameObject gameObject : GameObject.gameObjectList)
        {
            if(!root.getChildren().contains(gameObject))
            {
                root.getChildren().add(gameObject);
            }
        }
    }

    protected void createScene()
    {
        scene = new Scene(root, FirstView.screenSize.getX(), FirstView.screenSize.getY(), Color.BLACK);
    }
}
