package walkgame.objects.map;

import javafx.scene.Group;
import javafx.scene.image.Image;
import walkgame.objects.cast.Fog;
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

    public boolean visited;

    public Room(Image image, Coordinates coordinates) {//first room
        super(image, coordinates);
        innit();
        lastVisitedRoom = this;
    }

    private Room(Image image, Coordinates coordinates, Room room, char floortype) {//all other rooms
        super(image, coordinates);
        innit();

        super.setCoordinate(coordinates);//todo: cordinate parameter weg
        switch (floortype)
        {
            case 'N':
                this.roomNorth = room;

                break;
            case 'E':
                this.roomEast = room;

                break;
            case 'S':
                this.roomSouth = room;

                break;
            case 'W':
                this.roomWest = room;

                break;
        }
    }

    private void innit()
    {
        fog = new Fog(this);
        visited = false;
    }

    public void enterRoom()
    {
        if(!visited)
        {
            visited = true;
            if(roomNorth == null){
                roomNorth = new Room(new Image("walkgame/res/floor1.png"), new Coordinates(super.getX(), super.getY() - super.getImage().getHeight()), this, 'S'); }
            if(roomEast == null){
                roomEast = new Room(new Image("walkgame/res/floor1.png"), new Coordinates(super.getX() + super.getImage().getWidth(), super.getY()), this, 'W');}
            if(roomSouth == null){
                roomSouth = new Room(new Image("walkgame/res/floor1.png"), new Coordinates(super.getX(), super.getY() + super.getImage().getHeight()), this, 'N');}
            if(roomWest == null){
                roomWest = new Room(new Image("walkgame/res/floor1.png"), new Coordinates(super.getX() - super.getImage().getWidth(), super.getY()), this, 'E');}
        }

        Room.lastVisitedRoom.leaveRoom(this);
        Room.lastVisitedRoom = this;

        for(Room room : getNextDoorArray())
        {
            room.fog.setVisible(false);
        }
    }

    private void leaveRoom(Room newRoom)
    {
        for (Room room : getNextDoorArray())
        {
            if(!room.equals(newRoom))
            {
                room.fog.setVisible(true);
            }
        }
    }

    private void addFog()
    {
        //super.se
    }

    private void removeFog()
    {

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
