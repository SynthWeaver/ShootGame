package walkgame.objects.guns;

import walkgame.objects.bullets.Bullet;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentObjects.GameObject;

abstract class SemiAutomaticGun extends Gun {

    private static final int RATE_OF_FIRE = 0;

    SemiAutomaticGun(String name, int ammoCount, int clipSize, double reloadTime) {
        super(name, ammoCount, clipSize, RATE_OF_FIRE, reloadTime);
    }

    @Override
    public void shoot(Coordinates gunCoordinates, Coordinates directionCoordinates) {
        boolean containsBullet = false;
        for (GameObject object : GameObject.gameObjectList)
        {
            if(object instanceof Bullet)
            {
                containsBullet = true;
            }
        }

        if(!containsBullet)
        {
            shootBullet(gunCoordinates, directionCoordinates);
        }
    }

    @Override
    public void releaseTrigger() {
        return;
    }
}
