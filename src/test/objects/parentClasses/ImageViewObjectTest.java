package test.objects.parentClasses;

import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;
import walkgame.objects.map.Room;
import walkgame.objects.microObjects.Compass;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentClasses.ImageViewObject;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImageViewObjectTest extends TestClasses {

    ImageViewObject imageViewObject;

    @BeforeEach
    void setUp() {
        super.innit();
        imageViewObject = new Room(new Image("walkgame/res/floor1.png"), new Coordinates(0,0));
    }

    @Test
    void getCoordinate() {
        String expected = "0.00.0";
        String actual = String.format("%S%S", imageViewObject.getCoordinate().getX(), imageViewObject.getCoordinate().getY());
        assertEquals(expected, actual);
    }

    @Test
    void getCollisionDirection() {
        Coordinates[] coordinatesList = {new Coordinates(0,-300), new Coordinates(300,0), new Coordinates(0,300), new Coordinates(-300,0)};
        char[] compass = {Compass.NORTH, Compass.EAST, Compass.SOUTH, Compass.WEST};

        for (int i = 0; i < coordinatesList.length; i++) {
            System.out.println("test: " + compass[i]);
            room = new Room(room.getImage(), coordinatesList[i]);
            char expected = compass[i];
            char actual = imageViewObject.getCollisionDirection(room);
            assertEquals(expected, actual);
        }
    }

    @Test
    void containsObject() {
        boolean expected = true;
        boolean actual = imageViewObject.containsObject(player);
        assertEquals(expected, actual);

        expected = false;
        actual = player.containsObject(new Room(room.getImage(), new Coordinates(300, 300)));
        assertEquals(expected, actual);
    }

    @Test
    void getCenter() {
        Coordinates a = room.getCenter();
        Coordinates b = new Coordinates(150,150);

        boolean expected = true;
        boolean actual = a.equals(b);
        assertEquals(expected, actual);

        b = new Coordinates(100,100);

        expected = false;
         actual = a.equals(b);
        assertEquals(expected, actual);
    }
}