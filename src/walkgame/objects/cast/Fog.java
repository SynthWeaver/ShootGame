package walkgame.objects.cast;

import javafx.scene.Group;
import javafx.scene.effect.ColorAdjust;
import walkgame.objects.map.Room;
import walkgame.objects.parentClasses.ImageViewObject;

public class Fog extends ImageViewObject
{
    public static Group group = new Group();
    public Room room;

    private static final ColorAdjust UNKNOWN_FOG = new ColorAdjust(0,0, -1,0);
    private static final ColorAdjust KNOWN_FOG = new ColorAdjust(0,0, -0.4,0);

    private static final boolean isSolid = false;

    public Fog(Room room)
    {
        super(room.getImage(), room.getCoordinate());
        hideFog();
        this.room = room;
        setToFogToUnknown();
    }

    public void setToFogToUnknown()
    {
        super.setEffect(UNKNOWN_FOG);
    }

    public void setToFogToKnown()
    {
        super.setEffect(KNOWN_FOG);
    }

    public boolean hasFog()
    {
        return super.isVisible();
    }

    public void hideFog()
    {
        super.setVisible(false);
    }

    public void showFog()
    {
        super.setVisible(true);
    }

    @Override
    public boolean isSolid() {
        return isSolid;
    }

    @Override
    public void addNodeToList()
    {
        Fog.group.getChildren().add(this);
    }
}
