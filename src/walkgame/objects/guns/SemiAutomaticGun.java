package walkgame.objects.guns;

import javafx.scene.Node;
import walkgame.objects.bullets.Bullet;
import walkgame.objects.microObjects.Coordinates;
import walkgame.views.parentClasses.MainView;

abstract class SemiAutomaticGun extends Gun {

    SemiAutomaticGun(String name, int ammoCount, int clipSize, double reloadTime) {
        super(name, ammoCount, clipSize, reloadTime);
    }

    @Override
    public void shoot(Coordinates gunCoordinates, Coordinates directionCoordinates) {
        if(super.getClipAmmo() >= 1) {
            boolean containsBullet = false;
            for (Node object : MainView.currentMap) {
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
