package walkgame.objects.cast.bullets;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class PistolBullet extends Bullet {

    private static final Image IMAGE = new Image("walkgame/res/bullet/bullet.png");

    public PistolBullet(Point2D gunCoordinates, Point2D directionCoordinates) {
        super(IMAGE, gunCoordinates, directionCoordinates);
    }
}
