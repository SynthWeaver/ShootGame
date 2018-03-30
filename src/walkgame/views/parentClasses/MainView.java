package walkgame.views.parentClasses;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import walkgame.objects.hud.Player;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.Map;

import java.util.ArrayList;

public abstract class MainView extends gameloop.View {

    protected Map map = new Map();
    protected Group cast = new Group();
    protected Group hud = new Group();

    protected Group root = new Group(map, cast, hud);

    public Scene scene;

    private static Stage primaryStage;

    public static Coordinates screenSize = new Coordinates(300, 300);
    //public Coordinates gameSize = new Coordinates(400, 400);

    //private static SimpleDoubleProperty screenCenterX = new SimpleDoubleProperty();
    //private static SimpleDoubleProperty screenCenterY = new SimpleDoubleProperty();
    public static Coordinates screenCenter = new Coordinates(screenSize.getX() / 2f, screenSize.getY() / 2f);

    public static Coordinates playerSpawn = new Coordinates(screenCenter.getX() - (Player.PLAYER_SIZE.getX() / 2f) , screenCenter.getY() - (Player.PLAYER_SIZE.getY() / 2f));

    public MainView(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createScene();

        //screenCenterX.bind(this.scene.widthProperty());
        //screenCenterY.bind(this.scene.heightProperty());
        //screenCenter = new Coordinates(screenCenterX.get() / 2f, screenCenterY.get() / 2f);
    }

    @Override
    public void render()
    {
        return;
    }

    protected void createScene()
    {
        scene = new Scene(root, MainView.screenSize.getX(), MainView.screenSize.getY(), Color.BLACK);
    }

    public static Scene getCurrentScene()
    {
        return MainView.primaryStage.getScene();
    }

    public static Group[] getRootArray() {
        ObservableList<Node> nodeList = getCurrentScene().getRoot().getChildrenUnmodifiable();
        ArrayList<Group> groupList = new ArrayList<>();

        for(Node node : nodeList)//nodeList to groupList
        {
            groupList.add((Group) node);
        }

        return groupList.toArray(new Group[groupList.size()]);
    }

    public static ObservableList<Node> getMap() {
        Group map = getRootArray()[0];
        return map.getChildren();
    }

    public static ObservableList<Node> getCast() {
        Group cast = getRootArray()[1];
        return cast.getChildren();
    }

    public static ObservableList<Node> getHud() {
        Group hud = getRootArray()[2];
        return hud.getChildren();
    }

    public static void setCurrentScene(Scene scene)
    {
        MainView.primaryStage.setScene(scene);
    }
}
