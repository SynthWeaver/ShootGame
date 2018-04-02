package test.objects.map;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import walkgame.objects.map.Room;
import walkgame.objects.microObjects.Coordinates;

class RoomTest{

    Room room;

    @BeforeEach
    void setUp() {
        new JFXPanel();
        room = new Room(new Image("walkgame/res/floor1.png"), new Coordinates(0,0));
    }

    @Test
    void enterRoom() {
        room.enterRoom();

        System.out.println("check next rooms are filled");
        boolean expected = true;
        boolean actual = !room.nextRooms.isEmpty();

        Assertions.assertEquals(expected, actual);
    }
}