package walkgame.objects.microObjects.guns;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import walkgame.objects.cast.bullets.Bullet;

public abstract class SemiAutomaticGun extends Gun {

    SemiAutomaticGun(String name, Image image, SimpleIntegerProperty ammoCount, int clipSize, double reloadTime) {
        super(name, image, ammoCount, clipSize, reloadTime);
    }

    @Override
    public void shoot(Point2D gunCoordinates, Point2D directionCoordinates) {
        if(super.getClipAmmo().get() >= 1) {
            boolean containsBullet = false;
            for (Node object : Bullet.group.getChildren()) {
                if (object instanceof Bullet) {
                    containsBullet = true;
                }
            }

            if (!containsBullet) {
                shootBullet(gunCoordinates, directionCoordinates);
                super.removeBulletFromClip();
            }
        }
        else{
            //todo: no ammo warning
        }
    }

    @Override
    public void releaseTrigger() {
        return;
    }
}
