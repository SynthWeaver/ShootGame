package test.objects.hud;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import walkgame.objects.hud.Player;
import walkgame.objects.map.Room;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.guns.Pistol;
import walkgame.views.FirstMainView;
import walkgame.views.parentClasses.MainView;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;
    Room room;

    @BeforeEach
    void setUp() {
        new JFXPanel();

        player = new Player(MainView.playerSpawn, "Jack", new Pistol());
        room = new Room(new Image("walkgame/res/floor1.png"), new Coordinates(0,0));
    }

    @Test
    void move() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Coordinates firstCoordinates = player.getCoordinate();

                FirstMainView firstMainView = new FirstMainView(new Stage());
                firstMainView.firstViewController.pressKeyButton(KeyCode.W);
                firstMainView.firstViewController.tick();

                boolean expected = false;
                boolean actual = firstCoordinates.equals(player.getCoordinate());

                assertEquals(expected, actual);
            }
        });


    }

    @Test
    void getCoordinate() {//niet gelijk aan super getX!
    }

    @Test
    void rotateImage() {
    }

    @Test
    void pressButton() {
    }

    @Test
    void releaseButton() {
    }

    @Test
    void destroy() {
    }

    @Test
    void addNodeToList() {
    }
}