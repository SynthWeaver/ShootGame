package test.objects.parentClasses;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;
import walkgame.objects.map.Room;
import walkgame.objects.parentClasses.ImageViewObject;

import static org.junit.jupiter.api.Assertions.*;

class ImageViewObjectTest extends TestClasses {

    ImageViewObject imageViewObject;

    @BeforeEach
    void setUp() {
        super.innit();
        imageViewObject = new Room(new Point2D(0,0));
    }

    @Test
    void getCoordinate() {
        String expected = "0.00.0";
        String actual = String.format("%S%S", imageViewObject.getX(), imageViewObject.getY());
        assertEquals(expected, actual);
    }

    @Test
    void containsObject() {
        assertTrue(imageViewObject.contains(player.getPoint2D()));

        assertFalse(player.contains((new Room(new Point2D(300, 300))).getPoint2D()));
    }

    @Test
    void getCenter() {
        Point2D a = room.getCenter();
        Point2D b = new Point2D(150,150);

        assertTrue(a.equals(b));

        b = new Point2D(100,100);
        
        assertFalse(a.equals(b));
    }
}