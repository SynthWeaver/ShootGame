package walkgame.objects.parentClasses;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import walkgame.interfaces.GameInterface;
import walkgame.objects.microObjects.Coordinates;

public abstract class ImageViewObject extends ImageView implements GameInterface
{
    public ImageViewObject(Coordinates coordinates)
    {
        super();
        innit(coordinates);
    }

    public ImageViewObject(Image image, Coordinates coordinates)
    {
        super(image);
        innit(coordinates);
    }

    private void innit(Coordinates coordinates)
    {
        super.setX(coordinates.getX());
        super.setY(coordinates.getY());

        addNodeToList();
    }

    @Override
    public Coordinates getCoordinate()
    {
        return new Coordinates(getX(), getY());
    }

    @Override
    public abstract void addNodeToList();
}
