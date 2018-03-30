package walkgame.objects.map;

import javafx.scene.Group;
import javafx.scene.image.Image;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentClasses.ImageViewObject;

public class Floor extends ImageViewObject
{
    public static Group group = new Group();//todo: map fixen

    public Floor(Image image, Coordinates coordinates) {
        super(image, coordinates);
    }

    @Override
    public void addNodeToList()
    {
        Floor.group.getChildren().add(this);
    }
}
