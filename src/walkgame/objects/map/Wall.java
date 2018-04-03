package walkgame.objects.map;

import javafx.scene.Group;
import javafx.scene.image.Image;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentClasses.ImageViewObject;

public class Wall extends ImageViewObject {
    public static Group group = new Group();
    private Room room;

    public static final Image STANDARD_IMAGE = new Image("walkgame/res/map/wall.png");

    public Wall(Coordinates coordinates, Room room) {
        super(STANDARD_IMAGE, coordinates);
        this.room = room;
    }

    @Override
    public void addNodeToList() {
        Wall.group.getChildren().add(this);
    }
}
