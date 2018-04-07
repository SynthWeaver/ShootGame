package walkgame.objects.microObjects.guns;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public abstract class AutomaticGun extends Gun {

    private double rateOfFire;

    AutomaticGun(String name, Image image, SimpleIntegerProperty ammoCount, int clipSize, double rateOfFire, double reloadTime) {
        super(name, image, ammoCount, clipSize, reloadTime);
        this.rateOfFire = rateOfFire;
    }

    @Override
    public void shoot(Point2D gunCoordinates, Point2D directionCoordinates) {

    }

    @Override
    public void releaseTrigger() {

    }

    public double getRateOfFire() {
        return rateOfFire;
    }
}
