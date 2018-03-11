package walkgame.views.parentClasses;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import walkgame.objects.UI.Player;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.Map;

public abstract class MainView extends gameloop.View {

    public static Map map = new Map();
    public static ObservableList<Node> currentMapList = map.getChildren();

    public static Group cast = new Group();
    public static Group hud = new Group();

    private Group rootGroup = new Group(map, cast, hud);
    public ObservableList<Node> root = rootGroup.getChildren();

    public Scene scene;
    private Stage primaryStage;

    public static Coordinates screenSize = new Coordinates(300, 300);
    //public Coordinates gameSize = new Coordinates(400, 400);
    public static Coordinates screenCenter = new Coordinates(screenSize.getX() / 2f, screenSize.getY() / 2f);
    public static Coordinates playerSpawn = new Coordinates(screenCenter.getX() - (Player.PLAYER_SIZE.getX() / 2f) , screenCenter.getY() - (Player.PLAYER_SIZE.getY() / 2f));

    public MainView(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createScene();
    }

    @Override
    public void render()
    {

    }

    protected void createScene()
    {
        scene = new Scene(rootGroup, MainView.screenSize.getX(), MainView.screenSize.getY(), Color.BLACK);
    }
}
