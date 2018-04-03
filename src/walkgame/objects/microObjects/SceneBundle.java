package walkgame.objects.microObjects;

import javafx.scene.Scene;
import walkgame.exceptions.ObjectNotInListException;

import java.util.ArrayList;

public class SceneBundle {
    private int index;
    private ArrayList<Scene> scenes;

    public SceneBundle() {
        this.index = -1;
        this.scenes = new ArrayList<>();
    }

    public int getIndex() {
        return index;
    }

    public Scene getLastScene() {
        return scenes.get(index);
    }

    public void changeScene(int index) throws IndexOutOfBoundsException {
        Scene scene = getSceneById(index);
        scenes.remove(index);
        scenes.add(scene);
    }

    private Scene getSceneById(int index) throws IndexOutOfBoundsException {
        if(index >= scenes.size()) {
            throw new IndexOutOfBoundsException(index);
        }
        return scenes.get(index);
    }

    public void addScene(Scene scene) {
        scenes.add(scene);
        index++;
    }
}
