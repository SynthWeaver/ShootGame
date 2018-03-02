package walkgame.interfaces;


import walkgame.objects.guns.Gun;
import walkgame.objects.microObjects.Coordinates;

public interface Shootable {
    void setCurrentGun(Gun currentGun);
    Gun getCurrentGun();
}
