package walkgame.objects.map;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import walkgame.objects.cast.Fog;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentClasses.ImageViewObject;
import walkgame.views.parentClasses.MainView;

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

    private static final boolean isSolid = false;
    public static final Image STANDARD_IMAGE = new Image("walkgame/res/map/room.png");

    public boolean visited;

    public Room(Coordinates coordinates) {
        super(STANDARD_IMAGE, coordinates);
        innit(STANDARD_IMAGE);
        if(lastVisitedRoom == null)//firstRoom
        {
            enterRoom();
        }
    }

    private void innit(Image image)
    {
        visited = false;
        renderWalls();

        NORTH_ROOM_COORDINATES = new Coordinates(super.getX(), super.getY() - super.getHeight());
        EAST_ROOM_COORDINATES = new Coordinates(super.getTotalWidth(), super.getY());
        SOUTH_ROOM_COORDINATES = new Coordinates(super.getX(), super.getTotalHeight());
        WEST_ROOM_COORDINATES =  new Coordinates(super.getX() - super.getWidth(), super.getY());

        fog = new Fog(this);
    }

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
                    if(this.contains(room.getSceneHorizontalCenter(), room.getSceneMaxY() + 1))
                    {
                        if(this.roomNorth == null){this.roomNorth = room;}
                    }
                    else if(this.contains(room.getSceneX() - 1, room.getSceneVerticalCenter()))
                    {
                        if(this.roomEast == null){this.roomEast = room;}
                    }
                    else if(this.contains(room.getSceneHorizontalCenter(), room.getSceneY() - 1))
                    {
                        if(this.roomSouth == null){this.roomSouth = room;}
                    }
                    else if(this.contains(room.getSceneMaxX() + 1, room.getSceneVerticalCenter()))
                    {
                        if(this.roomWest == null){this.roomWest = room;}
                    }
                }
            }

            if(this.roomNorth == null){
                this.roomNorth = new Room(NORTH_ROOM_COORDINATES);}
            if(this.roomEast == null){
                this.roomEast = new Room(EAST_ROOM_COORDINATES);}
            if(this.roomSouth == null){
                this.roomSouth = new Room(SOUTH_ROOM_COORDINATES);}
            if(this.roomWest == null){
                this.roomWest = new Room(WEST_ROOM_COORDINATES);}
        }

    }

    private void renderWalls() {
        double screenCenter = MainView.getScreenCenter().getX();
        double wallSize = Wall.STANDARD_IMAGE.getWidth();

        //left wall
        for (int i = 0; i < super.getWidth() ; i += wallSize) {
            if(i >= screenCenter - 30 && i <= screenCenter + 30)
            {
                new Door(new Coordinates(getX(), getY() + i), this);
            }
            else
            {
                new Wall(new Coordinates(getX(), getY() + i), this);
            }
        }

        //right wall
        for (int i = 0; i < super.getWidth() ; i += wallSize) {
            if(i >= screenCenter - 30 && i <= screenCenter + 30)
            {
                new Door(new Coordinates(getTotalWidth() - wallSize, getY() + i), this);
            }
            else
            {
                new Wall(new Coordinates(getTotalWidth() - wallSize, getY() + i), this);
            }
        }

        //top wall
        for (int i = 0; i < super.getWidth() ; i += wallSize) {
            if(i >= screenCenter - 30 && i <= screenCenter + 30)
            {
                new Door(new Coordinates(getX() + i, getY()), this);
            }
            else{
                new Wall(new Coordinates(getX() + i, getY()), this);
            }
        }

        //bottom wall
        for (int i = 0; i < super.getWidth() ; i += wallSize) {
            if(i >= screenCenter - 30 && i <= screenCenter + 30)
            {
                new Door(new Coordinates(getX() + i, getTotalHeight() - wallSize), this);
            }
            else{
                new Wall(new Coordinates(getX() + i, getTotalHeight() - wallSize), this);
            }
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
    public boolean isSolid() {
        return isSolid;
    }

    @Override
    public void addNodeToList()
    {
        Room.group.getChildren().add(this);
    }
}
