package walkgame.objects.parentObjects;

import gameloop.GameLoop;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import walkgame.objects.microObjects.Coordinates;

import java.util.ArrayList;

public class GameObject extends ImageView
{
    public static final ArrayList<GameObject> gameObjectList = new ArrayList<>();

    public GameObject(Image image, Coordinates coordinates)
    {
        super(image);
        this.id = gameObjectList.size();

        super.setX(coordinates.getX());
        super.setY(coordinates.getY());

        gameObjectList.add(this);
        GameLoop.doLogicUpdate();
    }

    public GameObject(Coordinates coordinates)
    {
        this( null, coordinates);
    }

    private int id;

    public Coordinates getCoordinate()
    {
        return new Coordinates(getX(), getY());
    }
}
