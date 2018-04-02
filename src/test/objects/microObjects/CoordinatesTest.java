package test.objects.microObjects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.MovableGroup;
import walkgame.views.parentClasses.MainView;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        boolean expected = false;
        boolean actual = coordinates.equals(b);
        assertEquals(expected,actual);

        b.setX(100);
        b.setY(100);

        expected = true;
        actual = coordinates.equals(b);
        assertEquals(expected,actual);

    }

    @Test
    void getRelativisedHudCoordinate() {
        MovableGroup movableGroup = MainView.getMovableGroup();

        boolean expected = true;
        boolean actual = coordinates.getRelativisedHudCoordinate().equals(new Coordinates(100,100));
        assertEquals(expected,actual);

        movableGroup.setX(100);
        movableGroup.setY(100);

        expected = false;
        actual = coordinates.getRelativisedHudCoordinate().equals(new Coordinates(100,100));
        assertEquals(expected,actual);

        movableGroup.setX(200);
        movableGroup.setY(200);

        expected = true;
        actual = coordinates.getRelativisedHudCoordinate().equals(new Coordinates(-100,-100));
        assertEquals(expected,actual);
    }

    @Test
    void add() {
        coordinates.add(new Coordinates(200, 200));

        boolean expected = true;
        boolean actual = coordinates.equals(new Coordinates(300, 300)) ;
        assertEquals(expected,actual);

        coordinates.add(new Coordinates(100, 100));

        expected = false;
        actual = coordinates.equals(new Coordinates(300, 300));
        assertEquals(expected,actual);
    }

    @Test
    void minus() {
        coordinates.minus(new Coordinates(200, 200));

        boolean expected = true;
        boolean actual = coordinates.equals(new Coordinates(-100, -100)) ;
        assertEquals(expected,actual);

        coordinates.minus(new Coordinates(100, 100));

        expected = false;
        actual = coordinates.equals(new Coordinates(300, 300));
        assertEquals(expected,actual);
    }

    @Test
    void cloneFromObject() {
        player.setCoordinate(Coordinates.cloneFromObject(room));

        boolean expected = true;
        boolean actual = player.getCoordinate().equals(room.getCoordinate());
        assertEquals(expected,actual);

        player.setCoordinate(100, 100);

        expected = false;
        actual = player.getCoordinate().equals(room.getCoordinate());
        assertEquals(expected,actual);
    }
}