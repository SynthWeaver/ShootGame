package walkgame.interfaces;


import walkgame.objects.guns.Gun;

public interface Shootable {
    void setCurrentGun(Gun currentGun);
    Gun getCurrentGun();
}
