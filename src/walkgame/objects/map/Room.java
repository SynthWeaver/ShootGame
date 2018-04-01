package walkgame.objects.map;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import walkgame.objects.cast.Fog;
import walkgame.objects.microObjects.Compass;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.parentClasses.ImageViewObject;

public class Room extends ImageViewObject
{
    public static Group group = new Group();//todo: de floor heeft 4 floor propetys + een boolean die checkt of de player er voor het eerst is.
    private static Room lastVisitedRoom;
    private Fog fog;

    public Room roomNorth;
    public Room roomEast;
    public Room roomSouth;
    public Room roomWest;

    public Coordinates NORTH_ROOM_COORDINATES;
    public Coordinates EAST_ROOM_COORDINATES;
    public Coordinates SOUTH_ROOM_COORDINATES;
    public Coordinates WEST_ROOM_COORDINATES;
    public Coordinates ROOM_SIZE;

    public boolean visited;

    public Room(Image image, Coordinates coordinates) {//first room
        super(image, coordinates);
        innit(image);
        lastVisitedRoom = this;
    }

    private Room(Image image, Coordinates coordinates, Room room, char floortype) {//all other rooms
        super(image, coordinates);
        innit(image);

        switch (floortype)
        {
            case 'N':
                this.roomNorth = room; break;
            case 'E':
                this.roomEast = room; break;
            case 'S':
                this.roomSouth = room; break;
            case 'W':
                this.roomWest = room; break;
        }
    }

    private void innit(Image image)
    {
        fog = new Fog(this);
        visited = false;
        ROOM_SIZE = new Coordinates(image.getWidth(), image.getHeight());
        NORTH_ROOM_COORDINATES = new Coordinates(super.getX(), super.getY() - super.getImage().getHeight());
        EAST_ROOM_COORDINATES = new Coordinates(super.getX() + super.getImage().getWidth(), super.getY());
        SOUTH_ROOM_COORDINATES = new Coordinates(super.getX(), super.getY() + super.getImage().getHeight());
        WEST_ROOM_COORDINATES =  new Coordinates(super.getX() - super.getImage().getWidth(), super.getY());
    }

    public void enterRoom()
    {
        renderRooms();

        Room.lastVisitedRoom.leaveRoom(this);
        Room.lastVisitedRoom = this;

        removeFog();
    }

    private void leaveRoom(Room newRoom)
    {
        addFog(newRoom);
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
                this.roomNorth = new Room(new Image("walkgame/res/floor1.png"), NORTH_ROOM_COORDINATES, this, Compass.SOUTH); }
            if(this.roomEast == null){
                this.roomEast = new Room(new Image("walkgame/res/floor1.png"), EAST_ROOM_COORDINATES, this, Compass.WEST);}
            if(this.roomSouth == null){
                this.roomSouth = new Room(new Image("walkgame/res/floor1.png"), SOUTH_ROOM_COORDINATES, this, Compass.NORTH);}
            if(this.roomWest == null){
                this.roomWest = new Room(new Image("walkgame/res/floor1.png"), WEST_ROOM_COORDINATES, this, Compass.EAST);}
        }
    }

    private void addFog(Room newRoom)
    {
        for (Room room : getNextDoorArray())
        {
            if(!room.equals(newRoom))
            {
                room.fog.setVisible(true);
            }
        }
    }

    private void removeFog()
    {
        for(Room room : getNextDoorArray())
        {
            room.fog.setVisible(false);
        }
    }

    public Room[] getNextDoorArray()
    {
        return new Room[]{roomNorth, roomEast, roomSouth, roomWest};
    }

    @Override
    public void addNodeToList()
    {
        Room.group.getChildren().add(this);
    }
}
