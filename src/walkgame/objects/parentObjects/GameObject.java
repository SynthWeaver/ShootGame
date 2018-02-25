package walkgame.objects.parentObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import walkgame.objects.microObjects.Coordinates;

import java.util.ArrayList;

public class GameObject extends ImageView
{
    public static final ArrayList<Integer> ID_LIST = new ArrayList<>();

    public GameObject(Coordinates coordinates, Image image, int health)
    {
        super(image);
        createID();

        super.setX(coordinates.getX());
        super.setY(coordinates.getY());
        this.health = health;
    }

    public GameObject(Coordinates coordinates, Image image)
    {
        this(coordinates, image, Integer.MAX_VALUE);
    }

    public GameObject(Coordinates coordinates , int health)
    {
        this(coordinates, null, health);
    }

    public GameObject(Coordinates coordinates)
    {
        this(coordinates, null, Integer.MAX_VALUE);
    }

    private int id;
    int health;

    private void createID()
    {
        id = ID_LIST.size();
        ID_LIST.add(id);
    }

    public Coordinates getCoordinate()
    {
        return new Coordinates(getX(), getY());
    }

    public int getHealth() {
        return health;
    }
}
