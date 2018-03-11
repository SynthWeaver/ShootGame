package walkgame.objects;

import javafx.scene.image.Image;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentClasses.GameObject;
import walkgame.views.parentClasses.MainView;

import java.util.ArrayList;

public class Floor extends GameObject
{
    public static ArrayList<Floor> floorList = new ArrayList<>();

    public Floor(Image image, Coordinates coordinates) {
        super(image, coordinates);
        Floor.floorList.add(this);
    }

    @Override
    public void addNodeToList() {
        addNodeToMapList();
    }
}
