package walkgame.objects.parentClasses;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import walkgame.interfaces.ListableNode;
import walkgame.interfaces.stage.InCast;
import walkgame.interfaces.stage.InHud;
import walkgame.interfaces.stage.InMap;
import walkgame.objects.microObjects.Coordinates;
import walkgame.views.parentClasses.MainView;

public abstract class GameObject extends ImageView implements ListableNode
{
    public GameObject(Image image, Coordinates coordinates)
    {
        super(image);
        this.id = MainView.currentMapList.size();

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
        if(this instanceof InMap)
        {
            MainView.map.getChildren().add(this);
        }
        else if(this instanceof InCast)
        {
            MainView.cast.getChildren().add(this);
        }
        else if(this instanceof InHud)
        {
            MainView.hud.getChildren().add(this);
        }
        //GameLoop.doLogicUpdate();
    }
}
