package walkgame.objects.parentClasses;

import gameloop.GameLoop;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import walkgame.interfaces.ListableNode;
import walkgame.objects.microObjects.Coordinates;
import walkgame.views.MainView;

public class GameObject extends ImageView implements ListableNode
{

    public GameObject(Image image, Coordinates coordinates)
    {
        super(image);
        this.id = MainView.nodeList.size();

        super.setX(coordinates.getX());
        super.setY(coordinates.getY());

        addNodeToList();
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

    @Override
    public void addNodeToList()
    {
        MainView.nodeList.add(this);
        GameLoop.doLogicUpdate();
    }
}
