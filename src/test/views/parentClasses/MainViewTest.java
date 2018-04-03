package test.views.parentClasses;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;
import walkgame.Main;
import walkgame.exceptions.ObjectNotInListException;
import walkgame.objects.microObjects.MovableGroup;
import walkgame.views.parentClasses.MainView;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainViewTest extends TestClasses {

    @BeforeEach
    void setUp() {
        super.innit();
    }

    @Test
    void getCurrentScene() {
        Scene expected = super.scene;
        Scene actual = MainView.getCurrentScene();
        assertEquals(expected, actual);
    }

    @Test
    void addScene() {
        MainView.addScene(new Scene(new Group()));

        Scene expected = super.scene;
        Scene actual = MainView.getCurrentScene();
        assertNotEquals(expected, actual);
    }

    @Test
    void changeScene() {
        Scene a = new Scene(new Group());
        MainView.addScene(a);
        Scene b = new Scene(new Group());
        MainView.addScene(b);
        Scene c = new Scene(new Group());
        MainView.addScene(c);

        Scene expected = a;
        Scene actual = MainView.getCurrentScene();
        assertNotEquals(expected, actual);

        expected = c;
        actual = MainView.getCurrentScene();
        assertEquals(expected, actual);

       MainView.changeScene(0);

        expected = a;
        actual = MainView.getCurrentScene();
        assertNotEquals(expected, actual);

        expected = super.scene;
        actual = MainView.getCurrentScene();
        assertEquals(expected, actual);
    }

    @Test
    void getRoot() {
        Group root = new Group(new MovableGroup(), new Group());
        scene = new Scene(root);
        MainView.addScene(scene);

        ObservableList<Node> expected = root.getChildren();
        ObservableList<Node> actual = MainView.getRoot();
        assertEquals(expected, actual);
    }

    @Test
    void getMovableGroup() {
        MovableGroup movableGroup = new MovableGroup();
        Group root = new Group(movableGroup, new Group());
        scene = new Scene(root);
        MainView.addScene(scene);

        MovableGroup expected = movableGroup;
        MovableGroup actual = MainView.getMovableGroup();
        assertEquals(expected, actual);
    }

    @Test
    void getMap() {
        MovableGroup movableGroup = new MovableGroup(new Group(), new Group(), new Group(), new Group());
        Group root = new Group(movableGroup, new Group());
        scene = new Scene(root);
        MainView.addScene(scene);

        Node expected = movableGroup.getChildren().get(0);
        Node actual = MainView.getMap();
        assertEquals(expected, actual);
    }

    @Test
    void getCast() {
        MovableGroup movableGroup = new MovableGroup(new Group(), new Group(), new Group(), new Group());
        Group root = new Group(movableGroup, new Group());
        scene = new Scene(root);
        MainView.addScene(scene);

        Node expected = movableGroup.getChildren().get(1);
        Node actual = MainView.getCast();
        assertEquals(expected, actual);
    }

    @Test
    void getFog() {
        MovableGroup movableGroup = new MovableGroup(new Group(), new Group(), new Group(), new Group());
        Group root = new Group(movableGroup, new Group());
        scene = new Scene(root);
        MainView.addScene(scene);

        Node expected = movableGroup.getChildren().get(2);
        Node actual = MainView.getFog();
        assertEquals(expected, actual);
    }

    @Test
    void getHud() {
        Group root = new Group(new MovableGroup(), new Group());
        scene = new Scene(root);
        MainView.addScene(scene);

        Node expected = root.getChildren().get(1);
        Node actual = MainView.getHud();
        assertEquals(expected, actual);
    }

    @Test
    void getRootArray() {
        MovableGroup movableGroup = new MovableGroup(new Group(), new Group(), new Group(), new Group());
        Group root = new Group(movableGroup, new Group());
        scene = new Scene(root);
        MainView.addScene(scene);

        Group[] expected = new Group[]{MainView.getMap(), MainView.getCast(), MainView.getFog(), MainView.getHud()};
        Group[] actual = MainView.getRootArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void getListOfAllNodes() {
        MovableGroup movableGroup = new MovableGroup(new Group(), new Group(), new Group(), new Group());
        scene = new Scene(new Group(movableGroup, new Group()));
        MainView.addScene(scene);

        ArrayList<Node> list = new ArrayList<>();
        for (Group root : MainView.getRootArray())
        {
            for (Node rootNode : root.getChildren())
            {
                Group rootGroup = (Group) rootNode;
                list.addAll(rootGroup.getChildren());
            }
        }

        ArrayList<Node> expected = list;
        ArrayList<Node> actual = MainView.getListOfAllNodes();
        assertEquals(expected, actual);
    }
}