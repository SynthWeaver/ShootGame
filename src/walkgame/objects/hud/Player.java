package walkgame.objects.hud;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import walkgame.interfaces.Controllable;
import walkgame.interfaces.Nameable;
import walkgame.interfaces.Shootable;
import walkgame.objects.map.Room;
import walkgame.objects.microObjects.*;
import walkgame.objects.microObjects.guns.Gun;
import walkgame.objects.parentClasses.Character;
import walkgame.views.parentClasses.MainView;

public class Player extends Character implements Controllable, Nameable, Shootable {

    public static Group group = new Group();

    private static final SimpleIntegerProperty PLAYER_HEALTH = new SimpleIntegerProperty(100);
    private static final double PLAYER_SPEED = 0;
    public static final Point2D PLAYER_SIZE  = new Point2D(32,32);
    private static final boolean isSolid = true;

    private String name;
    private Gun currentGun;
    private Room currentRoom;

    private static final Sprites PLAYER_SPRITES = new Sprites(
            new Image("walkgame/res/player/none/north.png"),
            new Image("walkgame/res/player/none/north_east.png"),
            new Image("walkgame/res/player/none/east.png"),
            new Image("walkgame/res/player/none/south_east.png"),
            new Image("walkgame/res/player/none/south.png"),
            new Image("walkgame/res/player/none/south_west.png"),
            new Image("walkgame/res/player/none/west.png"),
            new Image("walkgame/res/player/none/north_west.png")
    );


    public Player(Sprites sprites, Point2D playerSpawn, String name, Gun currentGun)
    {
        super(sprites, playerSpawn, PLAYER_HEALTH, PLAYER_SPEED);
        this.name = name;
        this.currentGun = currentGun;
        this.currentRoom =  (Room) Room.group.getChildren().get(0);
        super.setImage(sprites.getSprite(Angle.SOUTH));
    }

    public Player(Point2D playerSpawn, String name, Gun currentGun)
    {
        this(PLAYER_SPRITES, playerSpawn, name, currentGun);
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    public void setCurrentGun(Gun currentGun) {
        this.currentGun = currentGun;
    }

    public Gun getCurrentGun() {
        return currentGun;
    }

    public Room getCurrentRoom() {
         return currentRoom;
    }

    @Override
    public Point2D getPoint2D()
    {
        return Hud.hudToMovableGroup(super.getPoint2D());
    }

    @Override
    public Point2D getMaxPoint2D()
    {
        return Hud.hudToMovableGroup(super.getMaxPoint2D());
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public boolean contains(double localX, double localY) {
        return this.contains(new Point2D(localX, localY));
    }

    @Override
    public boolean contains(Point2D point2D) {
        Point2D playerCoordinates = this.getPoint2D();

        double playerX = playerCoordinates.getX();
        double playerY = playerCoordinates.getY();
        double playerWidth = super.getWidth();
        double playerHeight = super.getHeight();

        BoundingBox relativePlayerBox = new BoundingBox(playerX, playerY, playerWidth, playerHeight);

        return relativePlayerBox.contains(point2D);
    }

    @Override
    public void move()
    {
        return;
    }

    @Override
    public void rotateImage(Point2D mouseCoordinates) {
        Image image = sprites.getSprite(Angle.SOUTH);
        double angle = Functions.getAngle(MainView.getScreenCenter(), mouseCoordinates);


        if(angle > Angle.NORTH_NORTH_EAST && angle < Angle.NORTH_EAST_EAST)
        {
            image = sprites.getSprite(Angle.NORTH_EAST);
        }
        else if(angle > Angle.NORTH_NORTH_EAST && angle < Angle.SOUTH_EAST_EAST)
        {
            image = sprites.getSprite(Angle.EAST);
        }
        else if(angle > Angle.SOUTH_EAST_EAST && angle < Angle.SOUTH_SOUTH_EAST)
        {
            image = sprites.getSprite(Angle.SOUTH_EAST);
        }
        else if(angle > Angle.SOUTH_SOUTH_EAST && angle < Angle.SOUTH_SOUTH_WEST)
        {
            image = sprites.getSprite(Angle.SOUTH);
        }
        else if(angle > Angle.SOUTH_SOUTH_WEST && angle < Angle.SOUTH_WEST_WEST)
        {
            image = sprites.getSprite(Angle.SOUTH_WEST);
        }
        else if(angle > Angle.SOUTH_WEST_WEST && angle < Angle.NORTH_WEST_WEST)
        {
            image = sprites.getSprite(Angle.WEST);
        }
        else if(angle > Angle.NORTH_WEST_WEST && angle < Angle.NORTH_NORTH_WEST)
        {
            image = sprites.getSprite(Angle.NORTH_WEST);
        }
        else if(angle > Angle.NORTH_NORTH_WEST || angle < Angle.NORTH_NORTH_EAST)
        {
            image = sprites.getSprite(Angle.NORTH);
        }

        super.setImage(image);
    }

    @Override
    public void checkButton(Controlls controlls) {
        for(Key key : controlls.getPressedButtons())
        {
            pressButton(key);
        }
        for(Key key : controlls.getReleasedButtons())
        {
            releaseButton(key);
        }
    }

    private void pressButton(Key k) {
        if(k == Controlls.up) {
            goNorth = true;
            goSouth = false;
        }
        else if(k == Controlls.right) {
            goEast = true;
            goWest = false;
        }
        else if(k == Controlls.down) {
            goSouth = true;
            goNorth = false;
        }
        else if(k == Controlls.left) {
            goWest = true;
            goEast = false;
        }
        else if(k == Controlls.reload) {
            this.currentGun.reload();
            Controlls.reload.release();
        }
    }

    private void releaseButton(Key k) {
        if(k == Controlls.up) {
            goNorth = false;
        }
        else if(k == Controlls.right) {
            goEast = false;
        }
        else if(k == Controlls.down) {
            goSouth = false;
        }
        else if(k == Controlls.left) {
            goWest = false;
        }
    }

    @Override
    public void destroy() {
        Player.group.getChildren().remove(this);
    }

    @Override
    public boolean isSolid() {
        return isSolid;
    }

    @Override
    public void addNodeToList()
    {
        Player.group.getChildren().clear();
        Player.group.getChildren().add(0,this);

        MainView.CONTROLLABLE_LIST.add(this);
        MainView.DESTRUCTIBLE_LIST.add(this);
        MainView.SHOOTABLE_LIST.add(this);
    }
}
