package walkgame.objects.hud;

import gameloop.GameLoop;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import walkgame.interfaces.Controllable;
import walkgame.interfaces.Nameable;
import walkgame.interfaces.Shootable;
import walkgame.objects.microObjects.Angle;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.Functions;
import walkgame.objects.microObjects.Sprites;
import walkgame.objects.microObjects.guns.Gun;
import walkgame.objects.parentClasses.Character;
import walkgame.views.parentClasses.MainView;

public class Player extends Character implements Controllable, Nameable, Shootable {

    public static Group group = new Group();

    private static final SimpleIntegerProperty PLAYER_HEALTH = new SimpleIntegerProperty(100);
    private static final double PLAYER_SPEED = 0;
    public static final Coordinates PLAYER_SIZE  = new Coordinates(32,32);

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
        if(!goNorth && !goSouth)
        {
            super.setVelocityY(0);
        }
        if(!goEast && !goWest)
        {
            super.setVelocityX(0);
        }

        if(getVelocityX() != 0 && getVelocityY() != 0 ) {
            double x = getX();
            double y = getY();

            super.setX(x + getVelocityX());
            super.setY(y + getVelocityY());
        }
    }

    /**
     * Only use from movableGroup childs. use getX when calling from hud.
     * @return RELATIVISED coordinate of player location
     */
    @Override
    public Coordinates getCoordinate()
    {
        return super.getCoordinate().getRelativisedHudCoordinate();
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
    public void pressButton(KeyCode k) {
        switch (k){
            case W:
                goNorth = true;
                goSouth = false;
                break;
            case D:
                goEast = true;
                goWest = false;
                break;
            case S:
                goSouth = true;
                goNorth = false;
                break;
            case A:
                goWest = true;
                goEast = false;
                break;
            case R:
                this.currentGun.reload();
                break;
        }
    }

    @Override
    public void releaseButton(KeyCode k) {
        switch (k){
            case W: goNorth = false; break;
            case D: goEast = false; break;
            case S: goSouth = false; break;
            case A: goWest = false; break;
        }
    }

    @Override
    public void destroy() {
        Player.group.getChildren().remove(this);
        GameLoop.doLogicUpdate();
    }

    @Override
    public void addNodeToList()
    {
        Player.group.getChildren().clear();
        Player.group.getChildren().add(0,this);
    }
}
