package walkgame.objects.hud;

import gameloop.GameLoop;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Group;
import javafx.scene.image.Image;
import walkgame.interfaces.Controllable;
import walkgame.interfaces.Nameable;
import walkgame.interfaces.Shootable;
import walkgame.objects.microObjects.*;
import walkgame.objects.microObjects.guns.Gun;
import walkgame.objects.parentClasses.Character;
import walkgame.views.parentClasses.MainView;

public class Player extends Character implements Controllable, Nameable, Shootable {

    public static Group group = new Group();

    private static final SimpleIntegerProperty PLAYER_HEALTH = new SimpleIntegerProperty(100);
    private static final double PLAYER_SPEED = 0;
    public static final Coordinates PLAYER_SIZE  = new Coordinates(32,32);
    private static final boolean isSolid = true;

    private String name;
    private Gun currentGun;

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


    public Player(Sprites sprites, Coordinates playerSpawn, String name, Gun currentGun)
    {
        super(sprites, playerSpawn, PLAYER_HEALTH, PLAYER_SPEED);
        this.name = name;
        this.currentGun = currentGun;
        super.setImage(sprites.getSprite(Angle.SOUTH));
    }

    public Player(Coordinates playerSpawn, String name, Gun currentGun)
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

    @Override
    public void move()
    {
        return;
    }

    @Override
    public void rotateImage(Coordinates mouseCoordinates) {
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
        GameLoop.doLogicUpdate();
    }

    @Override
    public boolean isSolid() {
        return isSolid;
    }

    /*public double getRelativeX()
    {
        return getX() - MainView.getMovableGroup().getX();
    }

    public double getRelativeY()
    {
        return getY() - MainView.getMovableGroup().getY();
    }

    @Override
    public double getSceneMaxX() {
        return this.getRelativeX() + getWidth();
    }

    @Override
    public double getSceneMaxY() {
        return this.getRelativeY() + getHeight();
    }

    @Override
    public double getSceneHorizontalCenter()
    {
        return getRelativeX() + (getWidth() / 2f);
    }

    @Override
    public double getSceneVerticalCenter()
    {
        return getRelativeY() + (getHeight() / 2f);
    }

    public ImageView getRelativePlayer()
    {
        ImageView dummyPlayer = new ImageView();
        dummyPlayer.setX(this.getRelativeX());
        dummyPlayer.setY(this.getRelativeY());
        dummyPlayer.setImage(this.getImage());
        return dummyPlayer;
    }*/

    @Override
    public void addNodeToList()
    {
        Player.group.getChildren().clear();
        Player.group.getChildren().add(0,this);
    }
}
