package walkgame.views.parentClasses;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import walkgame.objects.hud.Player;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.MovableGroup;

import java.util.ArrayList;

public abstract class MainView extends gameloop.View {

    protected Group map = new Group();
    protected Group cast = new Group();
    protected Group hud = new Group();

    protected MovableGroup movableGroup = new MovableGroup();
    protected Group root = new Group();

    public Scene scene;

    private static Stage primaryStage;

    public static Coordinates screenSize = new Coordinates(300, 300);
    //public Coordinates gameSize = new Coordinates(400, 400);

    //private static SimpleDoubleProperty screenCenterX = new SimpleDoubleProperty();
    //private static SimpleDoubleProperty screenCenterY = new SimpleDoubleProperty();

    public static Coordinates playerSpawn = new Coordinates(MainView.getScreenCenter().getX() - (Player.PLAYER_SIZE.getX() / 2f) , MainView.getScreenCenter().getY() - (Player.PLAYER_SIZE.getY() / 2f));//todo: moet anders

    public MainView(Stage primaryStage) {
        MainView.primaryStage = primaryStage;
        //createScene();

        //screenCenterX.bind(this.scene.widthProperty());
        //screenCenterY.bind(this.scene.heightProperty());
        //screenCenter = new Coordinates(screenCenterX.get() / 2f, screenCenterY.get() / 2f);
    }

    @Override
    public void render()
    {
        return;
    }

    public static Coordinates getScreenCenter()
    {
        return new Coordinates(MainView.screenSize.getX() / 2f, MainView.screenSize.getY() / 2f);
    }

    public static Coordinates getRelativeScreenCoordinates()
    {
        double screenX = MainView.getMovableGroup().getX() * -1;
        double screenY = MainView.getMovableGroup().getY() * -1;
        return new Coordinates(screenX , screenY);
    }

    public static Coordinates getRelativeScreenCenter()
    {
        Coordinates screen = getRelativeScreenCoordinates();

        double screenCenterX = screen.getX() + MainView.getScreenCenter().getX();
        double screenCenterY = screen.getY() + MainView.getScreenCenter().getY();

        return new Coordinates(screenCenterX, screenCenterY);
    }

    protected void createScene()//todo: maak een static getAllNodesAsList methode
    {
        scene = new Scene(root, MainView.screenSize.getX(), MainView.screenSize.getY(), Color.BLACK);
    }

    public static Scene getCurrentScene()
    {
        return MainView.primaryStage.getScene();
    }

    public static ObservableList<Node> getRoot() {
        return getCurrentScene().getRoot().getChildrenUnmodifiable();
    }

    public static MovableGroup getMovableGroup(){
        ObservableList<Node> root = MainView.getRoot();
        return (MovableGroup) root.get(0);
    }

    public static Group getMap() {
        return (Group) MainView.getMovableGroup().getChildren().get(0);
    }

    public static Group getCast() {
        return (Group) MainView.getMovableGroup().getChildren().get(1);
    }

    public static Group getHud() {
        ObservableList<Node> root = MainView.getRoot();
        return  (Group) root.get(1);
    }

    public static Group[] getRootArray() {
        return new Group[]{getMap(), getCast(), getHud()};
    }

    public static ArrayList<Node> getListOfAllNodes(){
        ArrayList<Node> list = new ArrayList<>();

        for (Group root : MainView.getRootArray())
        {
            for (Node rootNode : root.getChildren())
            {
                Group rootGroup = (Group) rootNode;
                list.addAll(rootGroup.getChildren());
            }
        }

        return list;
    }

    public static void setCurrentScene(Scene scene)
    {
        MainView.primaryStage.setScene(scene);
    }
}
