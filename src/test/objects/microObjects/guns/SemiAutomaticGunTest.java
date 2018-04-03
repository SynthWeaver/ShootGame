package test.objects.microObjects.guns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;
import walkgame.objects.cast.bullets.Bullet;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.guns.Pistol;
import walkgame.objects.microObjects.guns.SemiAutomaticGun;

import static org.junit.jupiter.api.Assertions.*;

class SemiAutomaticGunTest extends TestClasses {//todo: maak

    SemiAutomaticGun semiAutomaticGun;

    @BeforeEach
    void setUp() {
        super.innit();
        semiAutomaticGun = new Pistol();
    }

    @Test
    void shoot() {
        for (int i = 0; i < 9; i++) {
            Bullet.group.getChildren().clear();
            semiAutomaticGun.shoot(new Coordinates(0,0), new Coordinates(0, 300));
        }
        assertFalse(Bullet.group.getChildren().isEmpty());

        Bullet.group.getChildren().clear();
        semiAutomaticGun.shoot(new Coordinates(0,0), new Coordinates(0, 300));
        assertTrue(Bullet.group.getChildren().isEmpty());
    }
}