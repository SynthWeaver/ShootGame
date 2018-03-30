package walkgame.objects.microObjects.guns;

import javafx.beans.property.SimpleIntegerProperty;
import walkgame.objects.microObjects.Coordinates;

abstract class AutomaticGun extends Gun {

    private double rateOfFire;

    AutomaticGun(String name, SimpleIntegerProperty ammoCount, int clipSize, double rateOfFire, double reloadTime) {
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
