package test.objects.cast.bullets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;
import walkgame.objects.cast.bullets.Bullet;
import walkgame.objects.cast.bullets.PistolBullet;
import walkgame.objects.microObjects.Coordinates;

import static org.junit.jupiter.api.Assertions.*;

class BulletTest extends TestClasses {

    Bullet bullet;

    @BeforeEach
    void setUp() {
        super.innit();
        bullet = new PistolBullet(new Coordinates(0, 0), new Coordinates(300, 0));
    }

    @Test
    void move() {
        double x = bullet.getX();
        bullet.move();

        double expected = x;
        double actual = bullet.getX();
        assertNotEquals(expected, actual);

        int expected2 = 1;
        int actual2 = bullet.getHealth().get();
        assertEquals(expected2, actual2);

        bullet.setX(1000);
        bullet.move();

        expected2 = 0;
        actual2 = bullet.getHealth().get();
        assertEquals(expected2, actual2);
    }
}