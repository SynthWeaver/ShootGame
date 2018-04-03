package test.objects.microObjects.guns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.guns.Gun;
import walkgame.objects.microObjects.guns.Pistol;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GunTest extends TestClasses {

    Gun gun;

    @BeforeEach
    void setUp() {
        super.innit();
        gun = new Pistol();
    }

    @Test
    void removeBulletFromClip() {
        int ammo = gun.getClipAmmo().get();
        gun.shoot(new Coordinates(0,0), new Coordinates(300,0));

        int expeted = ammo;
        int actual = gun.getClipAmmo().get();
        assertNotEquals(expeted, actual);
    }

    @Test
    void reload() {
    }
}