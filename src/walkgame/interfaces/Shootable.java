package walkgame.interfaces;


import walkgame.objects.microObjects.guns.Gun;

public interface Shootable {
    void setCurrentGun(Gun currentGun);
    Gun getCurrentGun();
}
