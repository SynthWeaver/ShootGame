package walkgame.objects;

import gameloop.GameLoop;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import walkgame.interfaces.Controllable;
import walkgame.interfaces.Nameable;
import walkgame.interfaces.Shootable;
import walkgame.objects.guns.Gun;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.Functions;
import walkgame.objects.microObjects.Sprites;
import walkgame.objects.parentClasses.Character;
import walkgame.views.parentClasses.MainView;

public class Player extends Character implements Controllable, Nameable, Shootable {

    private static final int PLAYER_HEALTH = 100;
    private static final double PLAYER_SPEED = 0;
    public static final Coordinates PLAYER_SIZE  = new Coordinates(32,32);

    public SimpleIntegerProperty healthProperty;// = new SimpleIntegerProperty(super.getHealth());
    public SimpleIntegerProperty ammoClipProperty;// = new SimpleIntegerProperty(this.getCurrentGun().getClipAmmo());
    public SimpleIntegerProperty ammoProperty;// = new SimpleIntegerProperty(this.getCurrentGun().getAmmoCount());

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
        super.setImage(sprites.getSprite(Coordinates.SOUTH));

        healthProperty = new SimpleIntegerProperty(super.getHealth());
        ammoClipProperty = new SimpleIntegerProperty(this.getCurrentGun().getClipAmmo());
        ammoProperty = new SimpleIntegerProperty(this.getCurrentGun().getAmmoCount());
    }

    public Player(Coordinates playerSpawn, String name, Gun currentGun)
    {
        this(PLAYER_SPRITES, playerSpawn, name, currentGun);
    }

    private String name;
    private Gun currentGun;


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

    @Override
    public void rotateImage(Coordinates mouseCoordinates) {
        Image image = sprites.getSprite(Coordinates.SOUTH);
        double angle = Functions.getAngle(MainView.screenCenter, mouseCoordinates);


        if(angle > Coordinates.NORTH_NORTH_EAST && angle < Coordinates.NORTH_EAST_EAST)
        {
            image = sprites.getSprite(Coordinates.NORTH_EAST);
        }
        else if(angle > Coordinates.NORTH_NORTH_EAST && angle < Coordinates.SOUTH_EAST_EAST)
        {
            image = sprites.getSprite(Coordinates.EAST);
        }
        else if(angle > Coordinates.SOUTH_EAST_EAST && angle < Coordinates.SOUTH_SOUTH_EAST)
        {
            image = sprites.getSprite(Coordinates.SOUTH_EAST);
        }
        else if(angle > Coordinates.SOUTH_SOUTH_EAST && angle < Coordinates.SOUTH_SOUTH_WEST)
        {
            image = sprites.getSprite(Coordinates.SOUTH);
        }
        else if(angle > Coordinates.SOUTH_SOUTH_WEST && angle < Coordinates.SOUTH_WEST_WEST)
        {
            image = sprites.getSprite(Coordinates.SOUTH_WEST);
        }
        else if(angle > Coordinates.SOUTH_WEST_WEST && angle < Coordinates.NORTH_WEST_WEST)
        {
            image = sprites.getSprite(Coordinates.WEST);
        }
        else if(angle > Coordinates.NORTH_WEST_WEST && angle < Coordinates.NORTH_NORTH_WEST)
        {
            image = sprites.getSprite(Coordinates.NORTH_WEST);
        }
        else if(angle > Coordinates.NORTH_NORTH_WEST || angle < Coordinates.NORTH_NORTH_EAST)
        {
            image = sprites.getSprite(Coordinates.NORTH);
        }

            super.setImage(image);
    }

    @Override
    public void pressButton(KeyCode c) {
        switch (c){
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
    public void releaseButton(KeyCode c) {
        switch (c){
            case W: goNorth = false; break;
            case D: goEast = false; break;
            case S: goSouth = false; break;
            case A: goWest = false; break;
        }
    }

    @Override
    public void addNodeToList()
    {
        GameLoop.doLogicUpdate();
    }
}
