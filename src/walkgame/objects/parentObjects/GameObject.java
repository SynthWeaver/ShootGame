package walkgame.objects.parentObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import walkgame.objects.microObjects.Coordinates;

import java.util.ArrayList;

public class GameObject extends ImageView
{
    public final static ArrayList<Integer> ID_LIST = new ArrayList<>();

    public GameObject(Coordinates coordinates, Image image)
    {
        super(image);
        createID();

        super.setX(coordinates.getX());
        super.setY(coordinates.getY());
    }

    public GameObject(Coordinates coordinates)
    {
        this(coordinates, null);
    }

    private int id;

    private void createID()
    {
        id = ID_LIST.size();
        ID_LIST.add(id);
    }

    public Coordinates getCoordinate()
    {
        return new Coordinates(getX(), getY());
    }
}
