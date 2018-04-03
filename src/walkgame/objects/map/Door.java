package walkgame.objects.map;

import javafx.scene.Group;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentClasses.ImageViewObject;

public class Door extends ImageViewObject {
    public static Group group = new Group();
    private Room room;

    public Door(Coordinates coordinates, Room room) {
        super(coordinates);
        this.room = room;
    }

    @Override
    public void addNodeToList() {
        Door.group.getChildren().add(this);
    }
}
