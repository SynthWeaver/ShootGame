package walkgame.objects.map;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import walkgame.interfaces.Solid;
import walkgame.objects.parentClasses.ImageViewObject;

public class Wall extends ImageViewObject implements Solid {
    public static Group group = new Group();
    private Room room;

    public static final Image STANDARD_IMAGE = new Image("walkgame/res/map/wall.png");

    public Wall(Point2D coordinates, Room room) {
        super(STANDARD_IMAGE, coordinates);
        this.room = room;
        room.containsObjects.add(this);
    }

    @Override
    public void addNodeToList() {
        Wall.group.getChildren().add(this);
    }
}
