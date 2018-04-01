package walkgame.objects.cast;

import javafx.scene.Group;
import javafx.scene.effect.ColorAdjust;
import walkgame.objects.map.Room;
import walkgame.objects.parentClasses.ImageViewObject;

public class Fog extends ImageViewObject
{
    public static Group group = new Group();
    public Room room;

    public Fog(Room room)
    {
        super(room.getImage(), room.getCoordinate());

        super.setVisible(false);

        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.4);
        super.setEffect(colorAdjust);

        this.room = room;
    }

    @Override
    public void addNodeToList()
    {
        Fog.group.getChildren().add(this);
    }
}
