package walkgame.objects.map;

import javafx.scene.image.Image;
import walkgame.interfaces.stage.InMap;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentClasses.GameObject;

import java.util.ArrayList;

public class Floor extends GameObject implements InMap
{
    public static ArrayList<Floor> floorList = new ArrayList<>();

    public Floor(Image image, Coordinates coordinates) {
        super(image, coordinates);
        Floor.floorList.add(this);
    }
}
