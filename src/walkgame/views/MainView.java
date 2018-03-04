package walkgame.views;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import walkgame.objects.Player;
import walkgame.objects.microObjects.Coordinates;

import java.util.ArrayList;

public abstract class MainView extends gameloop.View {

    public static ArrayList<Node> nodeList = new ArrayList<>();//todo: naar root veranderen

    public Group root;
    public Scene scene;
    private Stage primaryStage;

    public static Coordinates screenSize = new Coordinates(300, 300);
    //public Coordinates gameSize = new Coordinates(400, 400);
    public static Coordinates screenCenter = new Coordinates(screenSize.getX() / 2f, screenSize.getY() / 2f);
    public static Coordinates playerSpawn = new Coordinates(screenCenter.getX() - (Player.PLAYER_SIZE.getX() / 2f) , screenCenter.getY() - (Player.PLAYER_SIZE.getY() / 2f));

    public MainView(Stage primaryStage) {
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
        for(Node gameObject : MainView.nodeList)
        {
            if(!root.getChildren().contains(gameObject))
            {
                root.getChildren().add(gameObject);
            }
        }
    }

    protected void createScene()
    {
        scene = new Scene(root, MainView.screenSize.getX(), MainView.screenSize.getY(), Color.BLACK);
    }
}
