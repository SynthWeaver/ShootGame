package walkgame.views.parentClasses;

import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import walkgame.interfaces.Controllable;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;
import walkgame.interfaces.Shootable;
import walkgame.objects.hud.Player;
import walkgame.objects.microObjects.MovableGroup;
import walkgame.objects.microObjects.SceneBundle;

import java.util.ArrayList;

public abstract class MainView extends gameloop.View {

    protected Group map = new Group();
    protected Group cast = new Group();
    protected Group fog = new Group();
    protected Group hud = new Group();

    protected MovableGroup movableGroup = new MovableGroup();
    protected Group root = new Group();

    public Scene scene;
    protected static SceneBundle sceneBundle = new SceneBundle();

    public static Point2D screenSize = new Point2D(300, 300);
    public static Point2D playerSpawn = new Point2D(MainView.getScreenCenter().getX() - (Player.PLAYER_SIZE.getX() / 2f) , MainView.getScreenCenter().getY() - (Player.PLAYER_SIZE.getY() / 2f));//todo: moet anders

    public static final ArrayList<Controllable> CONTROLLABLE_LIST = new ArrayList<>();
    public static final ArrayList<Destructible> DESTRUCTIBLE_LIST = new ArrayList<>();
    public static final ArrayList<Moveable> MOVEABLE_LIST = new ArrayList<>();
    public static final ArrayList<Shootable> SHOOTABLE_LIST = new ArrayList<>();

    public MainView() {
        //scenes are now build in childsViews
    }

    @Override
    public void render()
    {
        return;
    }

    public static Point2D getScreenCenter()
    {
        return new Point2D(MainView.screenSize.getX() / 2f, MainView.screenSize.getY() / 2f);
    }

    protected void createScene()
    {
        scene = new Scene(root, MainView.screenSize.getX(), MainView.screenSize.getY(), Color.BLACK);
        MainView.addScene(scene);
    }

    public static Scene getCurrentScene()
    {
        return sceneBundle.getLastScene();
    }

    public static ObservableList<Node> getRoot() {
        return getCurrentScene().getRoot().getChildrenUnmodifiable();
    }

    public static MovableGroup getMovableGroup(){
        ObservableList<Node> root = MainView.getRoot();
        return (MovableGroup) root.get(0);
    }

    public static Player getCurrentPlayer()
    {
        return (Player) Player.group.getChildren().get(0);
    }

    public static Group getMap() {
        return (Group) MainView.getMovableGroup().getChildren().get(0);
    }

    public static Group getCast() {
        return (Group) MainView.getMovableGroup().getChildren().get(1);
    }

    public static Group getFog() {
        return (Group) MainView.getMovableGroup().getChildren().get(2);
    }

    public static Group getHud() {
        ObservableList<Node> root = MainView.getRoot();
        return  (Group) root.get(1);
    }

    public static Group[] getRootArray() {
        return new Group[]{getMap(), getCast(), getFog(), getHud()};
    }

    @Deprecated
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

        list.add(getMovableGroup());

        return list;
    }

    public static void addScene(Scene scene)
    {
        sceneBundle.addScene(scene);
    }

    public static void changeScene(int index)
    {
        sceneBundle.changeScene(index);
    }

    public static void clearScenes() {
        sceneBundle = new SceneBundle();
    }
}
