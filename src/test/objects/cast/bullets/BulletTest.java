package test.objects.cast.bullets;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;
import walkgame.objects.cast.bullets.Bullet;
import walkgame.objects.cast.bullets.PistolBullet;

import static org.junit.jupiter.api.Assertions.*;

class BulletTest extends TestClasses {

    Bullet bullet;

    @BeforeEach
    void setUp() {
        super.innit();
        bullet = new PistolBullet(new Point2D(150, 150), new Point2D(300, 0));
    }

    @Test
    void move() {
        double expected = bullet.getX();
        bullet.move();

        double actual = bullet.getX();
        assertNotEquals(expected, actual);
    }

    @Test
    void destroy() {
        int expected = 1;
        int actual = bullet.getHealth().get();
        assertEquals(expected, actual);

        bullet.setX(1000);
        bullet.move();

        expected = 0;
        actual = bullet.getHealth().get();
        assertEquals(expected, actual);

        bullet.destroy();

        assertTrue(Bullet.group.getChildren().isEmpty());
    }

    @Test
    void WallCollision() {
        bullet.move();

        int expected = 1;
        int actual = bullet.getHealth().get();
        assertEquals(expected, actual);

        bullet.setX(0);
        bullet.setY(0);
        bullet.move();

        expected = 0;
        actual = bullet.getHealth().get();
        assertEquals(expected, actual);
    }
}