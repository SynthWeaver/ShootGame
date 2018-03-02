package walkgame.objects.guns;

import walkgame.objects.bullets.PistolBullet;
import walkgame.objects.microObjects.Coordinates;

public class Pistol extends SemiAutomaticGun {

    private static final String NAME = "Pistol";
    private static final int AMMO_COUNT = 100;
    private static final int CLIP_SIZE = 9;
    private static final int RELOAD_TIME = 9;


    public Pistol() {
        super(NAME, AMMO_COUNT, CLIP_SIZE, RELOAD_TIME);
    }

    @Override
    void shootBullet(Coordinates gunCoordinates, Coordinates directionCoordinates)
    {
        new PistolBullet(gunCoordinates, directionCoordinates);
    }
}
