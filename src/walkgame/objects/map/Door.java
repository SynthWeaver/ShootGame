package walkgame.objects.map;

import javafx.scene.Group;
import javafx.scene.image.Image;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentClasses.ImageViewObject;

public class Door extends ImageViewObject {
    public static Group group = new Group();
    private Room room;

    public static final Image STANDARD_IMAGE = new Image("walkgame/res/map/door.png");
    private static final boolean isSolid = false;

    public Door(Coordinates coordinates, Room room) {
        super(STANDARD_IMAGE, coordinates);
        this.room = room;
    }

    @Override
    public boolean isSolid() {
        return isSolid;
    }

    @Override
    public void addNodeToList() {
        Door.group.getChildren().add(this);
    }
}
