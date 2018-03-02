package walkgame.objects.guns;

import walkgame.objects.microObjects.Coordinates;

abstract class AutomaticGun extends Gun {

    AutomaticGun(String name, int ammoCount, int clipSize, double rateOfFire, double reloadTime) {
        super(name, ammoCount, clipSize, rateOfFire, reloadTime);
    }

    @Override
    public void shoot(Coordinates gunCoordinates, Coordinates directionCoordinates) {

    }

    @Override
    public void releaseTrigger() {

    }
}
