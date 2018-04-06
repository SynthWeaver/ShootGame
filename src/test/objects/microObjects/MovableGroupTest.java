package test.objects.microObjects;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.TestClasses;
import walkgame.objects.microObjects.Controlls;
import walkgame.objects.microObjects.MovableGroup;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MovableGroupTest extends TestClasses {

    MovableGroup movableGroup;

    @BeforeEach
    void setUp() {
        super.innit();
        movableGroup = new MovableGroup();
    }

    @Test
    void move() {
        Point2D firstCoordinates = movableGroup.getPoint2D();

        assertTrue(firstCoordinates.equals(movableGroup.getPoint2D()));

        movableGroup.setVelocityX(100);
        movableGroup.setVelocityY(100);

        Controlls controll = new Controlls();
        controll.pressButton('W');
        movableGroup.checkButton(controll);
        movableGroup.move();

        assertFalse(firstCoordinates.equals(movableGroup.getPoint2D()));
    }
}