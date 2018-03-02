package walkgame.objects.guns;

import walkgame.objects.microObjects.Coordinates;

abstract class AutomaticGun extends Gun {

    private double rateOfFire;

    AutomaticGun(String name, int ammoCount, int clipSize, double rateOfFire, double reloadTime) {
        super(name, ammoCount, clipSize, reloadTime);
        this.rateOfFire = rateOfFire;
    }

    @Override
    public void shoot(Coordinates gunCoordinates, Coordinates directionCoordinates) {

    }

    @Override
    public void releaseTrigger() {

    }

    public double getRateOfFire() {
        return rateOfFire;
    }
}
