package test.objects.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest extends TestClasses {

    @BeforeEach
    void setUp() {
        super.innit();
    }

    @Test
    void enterRoom() {
        assertNull(room.roomEast.nextRooms);

        room.roomEast.enterRoom();
        assertNotNull(room.roomEast.nextRooms);
    }

    @Test
    void roomPlacement() {
        room.roomEast.enterRoom();
        room.roomEast.roomNorth.enterRoom();
        assertNotNull(room.roomEast.roomNorth.roomNorth);

        assertEquals(room.roomEast.roomNorth.roomWest, room.roomNorth);
    }
}