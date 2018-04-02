package test.objects.parentClasses;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import walkgame.Main;
import walkgame.objects.hud.Player;
import walkgame.objects.map.Room;
import walkgame.objects.microObjects.Compass;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.MovableGroup;
import walkgame.objects.microObjects.guns.Pistol;
import walkgame.objects.parentClasses.ImageViewObject;
import walkgame.views.FirstMainView;
import walkgame.views.parentClasses.MainView;

import static org.junit.jupiter.api.Assertions.*;

class ImageViewObjectTest{

    FirstMainView firstMainView;
    ImageViewObject imageViewObject;
    Player player;
    Room room;

    @BeforeEach
    void setUp() {
        new JFXPanel();

        imageViewObject = new Room(new Image("walkgame/res/floor1.png"), new Coordinates(0,0));
        player = new Player(MainView.playerSpawn, "Jack", new Pistol());
        room = new Room(new Image("walkgame/res/floor1.png"), new Coordinates(0,0));
    }

    @Test
    void getCoordinate() {
        String expected = "0.00.0";
        String actual = String.format("%S%S", imageViewObject.getCoordinate().getX(), imageViewObject.getCoordinate().getY());
        assertEquals(expected, actual);
    }

    @Test
    void getCollisionDirection() {
        room.setX(300);
        char expected = Compass.EAST;
        char actual = imageViewObject.getCollisionDirection(room);
        assertEquals(expected, actual);
    }

    @Test
    void containsObject() {//todo:fix deze
        boolean expected = true;
        boolean actual = imageViewObject.containsObject(player);
        assertEquals(expected, actual);
    }

    @Test
    void getCenter() {
        Coordinates a = room.getCenter();
        Coordinates b = new Coordinates(150,150);

        boolean expected = true;
        boolean actual = a.equals(b);
        assertEquals(expected, actual);
    }
}