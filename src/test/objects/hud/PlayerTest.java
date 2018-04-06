package test.objects.hud;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;
import walkgame.objects.hud.Player;
import walkgame.views.parentClasses.MainView;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest extends TestClasses {

    @BeforeEach
    void setUp() {
        super.innit();
    }

    @Test
    void rotateImage() {
        Image image = player.getImage();

        Image expected = image;
        Image actual = player.getImage();
        assertEquals(expected, actual);

        player.rotateImage(new Point2D(100, 100));

        expected = image;
        actual = player.getImage();
        assertNotEquals(expected, actual);
    }

    @Test
    void destroy() {
        Player expected = MainView.getCurrentPlayer();
        Player actual = player;
        assertEquals(expected, actual);

        player.destroy();

        assertTrue(Player.group.getChildren().isEmpty());
    }
}