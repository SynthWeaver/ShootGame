package walkgame.objects.map;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import walkgame.objects.parentClasses.ImageViewObject;

public class Wall extends ImageViewObject {
    public static Group group = new Group();
    private Room room;

    public static final Image STANDARD_IMAGE = new Image("walkgame/res/map/wall.png");
    private static final boolean isSolid = true;

    public Wall(Point2D coordinates, Room room) {
        super(STANDARD_IMAGE, coordinates);
        this.room = room;
        room.sollidObjects.add(this);
    }

    @Override
    public boolean isSolid() {
        return isSolid;
    }

    @Override
    public void addNodeToList() {
        Wall.group.getChildren().add(this);
    }
}
