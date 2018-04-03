package walkgame.objects.microObjects.guns;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Node;
import walkgame.objects.cast.bullets.Bullet;
import walkgame.objects.microObjects.Coordinates;

public abstract class SemiAutomaticGun extends Gun {

    SemiAutomaticGun(String name, SimpleIntegerProperty ammoCount, int clipSize, double reloadTime) {
        super(name, ammoCount, clipSize, reloadTime);
    }

    @Override
    public void shoot(Coordinates gunCoordinates, Coordinates directionCoordinates) {
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
