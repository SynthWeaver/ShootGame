package walkgame.objects.hud;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import walkgame.interfaces.Controllable;
import walkgame.interfaces.Nameable;
import walkgame.interfaces.Shootable;
import walkgame.objects.map.Room;
import walkgame.objects.microObjects.Controlls;
import walkgame.objects.microObjects.Functions;
import walkgame.objects.microObjects.Key;
import walkgame.objects.microObjects.guns.Gun;
import walkgame.objects.parentClasses.Character;
import walkgame.views.parentClasses.MainView;

public class Player extends Character implements Controllable, Nameable, Shootable {

    public static Group group = new Group();

    private static final Image STANDARD_IMAGE = new Image("walkgame/res/player/player.png");
    private static final SimpleIntegerProperty PLAYER_HEALTH = new SimpleIntegerProperty(100);
    private static final double PLAYER_SPEED = 0;

    private String name;
    private Gun currentGun;
    private Room currentRoom;


    public Player(Image[] image, String name, Gun currentGun)
    {
        super(image, new Point2D(0,0), PLAYER_HEALTH, PLAYER_SPEED);
        this.name = name;
        this.currentGun = currentGun;
        this.currentRoom =  (Room) Room.group.getChildren().get(0);


        Point2D playerSize = super.getSize();
        Point2D playerSpawn = new Point2D(MainView.getScreenCenter().getX() - (playerSize.getX() / 2f) , MainView.getScreenCenter().getY() - (playerSize.getY() / 2f));//todo: moet anders

        super.setX(playerSpawn.getX());
        super.setY(playerSpawn.getY());
    }

    public Player(String name, Gun currentGun)
    {
        this(new Image[]{STANDARD_IMAGE, currentGun.getImage()}, name, currentGun);
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
    public Point2D getCenter() {
        return Hud.hudToMovableGroup(super.getCenter());
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
    public boolean contains(Point2D point2D) {//todo: heeft nog bugs
        Bounds bounds = getPlayerImageBounds();

        Point2D relativeCoordinate = this.getPoint2D();

        double playerX = relativeCoordinate.getX() + bounds.getMinX();
        double playerY = relativeCoordinate.getY() + bounds.getMinY();
        double playerWidth = bounds.getWidth();
        double playerHeight = bounds.getHeight();

        BoundingBox relativePlayerBox = new BoundingBox(playerX, playerY, playerWidth, playerHeight);

        return relativePlayerBox.contains(point2D);
    }

    private Bounds getPlayerImageBounds()
    {
        Node node = super.getChildren().get(0);
        return node.getBoundsInParent();
    }

    @Override
    public void move()
    {
        return;
    }

    @Override
    public void rotateImage(Point2D mouseCoordinates) {
        double angle = Functions.getAngle(MainView.getScreenCenter(), mouseCoordinates);

        super.setRotate(angle);
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
        else if(k == Controlls.reload) {
            this.currentGun.reload();
        }
    }

    @Override
    public void destroy() {
        Player.group.getChildren().remove(this);
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
