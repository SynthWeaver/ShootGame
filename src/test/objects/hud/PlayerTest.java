package test.objects.hud;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;
import walkgame.objects.hud.Player;
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

        boolean expected = true;
        boolean actual = firstCoordinates.equals(player.getCoordinate());

        assertEquals(expected, actual);

        player.setVelocityX(100);
        player.setVelocityY(100);
        player.pressButton(KeyCode.W);
        player.pressButton(KeyCode.D);
        player.move();

        expected = false;
        actual = firstCoordinates.equals(player.getCoordinate());

        assertEquals(expected, actual);
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

        boolean expected2 = true;
        boolean actual2 = Player.group.getChildren().isEmpty();
        assertEquals(expected2, actual2);
    }
}