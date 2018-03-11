package walkgame.objects.parentClasses;

import gameloop.GameLoop;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import walkgame.interfaces.ListableNode;
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

    private void doLogicUpdate()
    {
        GameLoop.doLogicUpdate();
    }

    @Override
    public abstract void addNodeToList();

    protected void addNodeToMapList() {
        MainView.currentMapList.add(this);
        doLogicUpdate();
    }

    protected void addNodeToCastList() {
        MainView.cast.getChildren().add(this);
        doLogicUpdate();
    }

    protected void addNodeToHudList() {
        MainView.hud.getChildren().add(this);
        doLogicUpdate();
    }
}
