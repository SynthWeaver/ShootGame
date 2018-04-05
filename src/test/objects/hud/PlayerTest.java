package test.objects.hud;

import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;
import walkgame.objects.hud.Player;
import walkgame.objects.microObjects.Controlls;
import walkgame.objects.microObjects.Coordinates;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest extends TestClasses {

    @BeforeEach
    void setUp() {
        super.innit();
    }

    @Test
    void move() {
        Coordinates firstCoordinates = player.getCoordinate();

        assertTrue(firstCoordinates.equals(player.getCoordinate()));

        player.setVelocityX(100);
        player.setVelocityY(100);
        player.pressButton(Controlls.up);
        player.pressButton(Controlls.right);
        player.move();

        assertFalse(firstCoordinates.equals(player.getCoordinate()));
    }

    @Test
    void rotateImage() {
        Image image = player.getImage();

        Image expected = image;
        Image actual = player.getImage();
        assertEquals(expected, actual);

        player.rotateImage(new Coordinates(100, 100));

        expected = image;
        actual = player.getImage();
        assertNotEquals(expected, actual);
    }

    @Test
    void destroy() {
        Player expected = (Player) Player.group.getChildren().get(0);
        Player actual = player;
        assertEquals(expected, actual);

        player.destroy();

        assertTrue(Player.group.getChildren().isEmpty());
    }
}