package walkgame.objects.bullets;

import javafx.scene.image.Image;
import walkgame.objects.microObjects.Coordinates;

public class PistolBullet extends Bullet {

     private static final Image IMAGE = new Image("walkgame/res/bullet/bullet.png");

    public PistolBullet(Coordinates gunCoordinates, Coordinates directionCoordinates) {
        super(IMAGE, gunCoordinates, directionCoordinates);
    }

    @Override
    public void addNodeToList() {
        addNodeToCastList();
    }
}
