package test.objects.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;
import walkgame.objects.map.Room;

class RoomTest extends TestClasses {

    @BeforeEach
    void setUp() {
        super.innit();
    }

    @Test
    void enterRoom() {
        Room roomEast = room.roomEast;

        boolean expected = true;
        boolean actual = roomEast.nextRooms == null;
        Assertions.assertEquals(expected, actual);

        roomEast.enterRoom();
        expected = false;
        actual = room.nextRooms.isEmpty();
        Assertions.assertEquals(expected, actual);
    }
}