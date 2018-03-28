package walkgame.objects.parentClasses;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import walkgame.interfaces.GameInterface;
import walkgame.objects.microObjects.Coordinates;

public abstract class PaneObject extends Pane implements GameInterface
{
    public PaneObject(Coordinates coordinates)
    {
        super();
        innit(coordinates);
    }

    public PaneObject(Coordinates coordinates, Node... children)
    {
        super(children);
        innit(coordinates);
    }

    private void innit(Coordinates coordinates)
    {
        super.setLayoutX(coordinates.getX());
        super.setLayoutY(coordinates.getY());

        addNodeToList();
    }

    @Override
    public Coordinates getCoordinate()
    {
        return new Coordinates(super.getLayoutX(), super.getLayoutY());
    }

    @Override
    public abstract void addNodeToList();
}
