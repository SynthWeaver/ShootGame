package walkgame.objects.microObjects.guns;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import walkgame.objects.cast.bullets.PistolBullet;

public class Pistol extends SemiAutomaticGun {

    private static final String NAME = "Pistol";
    private static Image image = new Image("walkgame/res/weapon/pistol.png");
    private static final SimpleIntegerProperty AMMO_COUNT = new SimpleIntegerProperty(100);
    private static final int CLIP_SIZE = 9;
    private static final int RELOAD_TIME = 9;


    public Pistol() {
        super(NAME, image, AMMO_COUNT, CLIP_SIZE, RELOAD_TIME);
    }

    @Override
    void shootBullet(Point2D gunCoordinates, Point2D directionCoordinates)
    {
        new PistolBullet(gunCoordinates, directionCoordinates);
    }
}
