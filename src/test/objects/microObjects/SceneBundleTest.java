package test.objects.microObjects;

import javafx.scene.Group;
import javafx.scene.Scene;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;
import walkgame.objects.microObjects.SceneBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SceneBundleTest extends TestClasses {

    SceneBundle sceneBundle;

    @BeforeEach
    void setUp() {
        super.innit();
        sceneBundle = new SceneBundle();
    }

    @Test
    void getIndex() {
        int expected = sceneBundle.getIndex();
        sceneBundle.addScene(new Scene(new Group()));

        int actual = sceneBundle.getIndex();
        assertNotEquals(expected, actual);
    }

    @Test
    void getLastScene() {
        Scene expected = new Scene(new Group());
        sceneBundle.addScene(expected);

        Scene actual = sceneBundle.getLastScene();
        assertEquals(expected, actual);

        sceneBundle.addScene(new Scene(new Group()));

        actual = sceneBundle.getLastScene();
        assertNotEquals(expected, actual);
    }

    @Test
    void changeScene() {
        Scene expected = new Scene(new Group());
        sceneBundle.addScene(expected);
        sceneBundle.addScene(new Scene(new Group()));

        Scene actual = sceneBundle.getLastScene();
        assertNotEquals(expected, actual);

        sceneBundle.changeScene(0);

        actual = sceneBundle.getLastScene();
        assertEquals(expected, actual);
    }

    @Test
    void addScene() {
        Scene expected = new Scene(new Group());
        sceneBundle.addScene(expected);

        Scene actual = sceneBundle.getLastScene();
        assertEquals(expected, actual);
    }
}