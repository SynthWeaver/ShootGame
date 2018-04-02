package walkgame.objects.map;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import walkgame.objects.cast.Fog;
import walkgame.objects.microObjects.Compass;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentClasses.ImageViewObject;

import java.util.ArrayList;
import java.util.Arrays;

public class Room extends ImageViewObject
{
    public static Group group = new Group();
    public static Room lastVisitedRoom = null;
    private Fog fog;

    public Room roomNorth;
    public Room roomEast;
    public Room roomSouth;
    public Room roomWest;
    public ArrayList<Room> nextRooms;

    public Coordinates NORTH_ROOM_COORDINATES;
    public Coordinates EAST_ROOM_COORDINATES;
    public Coordinates SOUTH_ROOM_COORDINATES;
    public Coordinates WEST_ROOM_COORDINATES;
    public Coordinates ROOM_SIZE;

    public boolean visited;

    public Room(Image image, Coordinates coordinates) {
        super(image, coordinates);
        innit(image);
        if(lastVisitedRoom == null)
        {
            enterRoom();
        }
    }

    private void innit(Image image)
    {
        visited = false;
        ROOM_SIZE = new Coordinates(image.getWidth(), image.getHeight());
        NORTH_ROOM_COORDINATES = new Coordinates(super.getX(), super.getY() - super.getImage().getHeight());
        EAST_ROOM_COORDINATES = new Coordinates(super.getX() + super.getImage().getWidth(), super.getY());
        SOUTH_ROOM_COORDINATES = new Coordinates(super.getX(), super.getY() + super.getImage().getHeight());
        WEST_ROOM_COORDINATES =  new Coordinates(super.getX() - super.getImage().getWidth(), super.getY());

        fog = new Fog(this);
    }

    /**  */
    public void enterRoom()
    {
        Room.lastVisitedRoom = this;
        renderRooms();

        nextRooms = new ArrayList<>(Arrays.asList(roomNorth, roomEast, roomSouth, roomWest));

        addFog();
        scoutFog();
    }

    private void renderRooms()
    {
        if(!visited)
        {
            visited = true;

            for(Node node : Room.group.getChildren())
            {
                Room room = (Room) node;
                if(!room.equals(this))
                {
                    switch (this.getCollisionDirection(room))
                    {
                        case Compass.NORTH: if(this.roomNorth == null){this.roomNorth = room;} break;
                        case Compass.EAST:  if(this.roomEast == null){this.roomEast = room;} break;
                        case Compass.SOUTH: if(this.roomSouth == null){this.roomSouth = room;}break;
                        case Compass.WEST:  if(this.roomWest == null){this.roomWest = room;} break;
                    }
                }
            }

            if(this.roomNorth == null){
                this.roomNorth = new Room(new Image("walkgame/res/floor1.png"), NORTH_ROOM_COORDINATES);}
            if(this.roomEast == null){
                this.roomEast = new Room(new Image("walkgame/res/floor1.png"), EAST_ROOM_COORDINATES);}
            if(this.roomSouth == null){
                this.roomSouth = new Room(new Image("walkgame/res/floor1.png"), SOUTH_ROOM_COORDINATES);}
            if(this.roomWest == null){
                this.roomWest = new Room(new Image("walkgame/res/floor1.png"), WEST_ROOM_COORDINATES);}
        }

    }

    private void scoutFog()
    {
        this.fog.setToFogToKnown();
        for(Room room : nextRooms)
        {
            room.fog.setToFogToKnown();
            room.fog.hideFog();
        }
    }

    private void addFog()
    {
        for (Node node : Room.group.getChildren())
        {
            Room room = (Room) node;
            if(!this.equals(room) && !nextRooms.contains(room) && !room.fog.hasFog())
            {
                room.fog.showFog();
            }
        }
    }

    @Override
    public void addNodeToList()
    {
        Room.group.getChildren().add(this);
    }
}
