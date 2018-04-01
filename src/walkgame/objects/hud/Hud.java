package walkgame.objects.hud;

import javafx.scene.image.Image;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentClasses.ImageViewObject;

public class Hud extends ImageViewObject
{
    public Hud(Coordinates coordinates)
    {
        super(coordinates);
    }

    public Hud(Image image, Coordinates coordinates)
    {
        super(image, coordinates);
    }



    @Override
    public void addNodeToList()
    {

    }
}
