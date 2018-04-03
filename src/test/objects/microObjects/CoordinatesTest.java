package test.objects.microObjects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.MovableGroup;
import walkgame.views.parentClasses.MainView;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest extends TestClasses {

    Coordinates coordinates;

    @BeforeEach
    void setUp() {
        super.innit();
        coordinates =  new Coordinates(100, 100);
    }

    @Test
    void equals() {
        Coordinates b = new Coordinates(0,0);

        assertFalse(coordinates.equals(b));

        b.setX(100);
        b.setY(100);

        assertTrue(coordinates.equals(b));

    }

    @Test
    void getRelativisedHudCoordinate() {
        MovableGroup movableGroup = MainView.getMovableGroup();

        assertTrue(coordinates.getRelativisedHudCoordinate().equals(new Coordinates(100,100)));

        movableGroup.setX(100);
        movableGroup.setY(100);

        assertFalse(coordinates.getRelativisedHudCoordinate().equals(new Coordinates(100,100)));

        movableGroup.setX(200);
        movableGroup.setY(200);

        assertTrue(coordinates.getRelativisedHudCoordinate().equals(new Coordinates(-100,-100)));
    }

    @Test
    void add() {
        coordinates.add(new Coordinates(200, 200));

        assertTrue(coordinates.equals(new Coordinates(300, 300)));

        coordinates.add(new Coordinates(100, 100));

        assertFalse(coordinates.equals(new Coordinates(300, 300)));
    }

    @Test
    void minus() {
        coordinates.minus(new Coordinates(200, 200));

        assertTrue(coordinates.equals(new Coordinates(-100, -100)));

        coordinates.minus(new Coordinates(100, 100));

        assertFalse(coordinates.equals(new Coordinates(300, 300)));
    }

    @Test
    void cloneFromObject() {
        player.setCoordinate(Coordinates.cloneFromObject(room));

        assertTrue(player.getCoordinate().equals(room.getCoordinate()));

        player.setCoordinate(100, 100);

        assertFalse(player.getCoordinate().equals(room.getCoordinate()));
    }
}