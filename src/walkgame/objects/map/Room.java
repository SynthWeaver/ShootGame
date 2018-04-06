package walkgame.objects.map;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import walkgame.interfaces.Moveable;
import walkgame.objects.cast.Fog;
import walkgame.objects.microObjects.Compass;
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
    public ArrayList<ImageViewObject> sollidObjects = new ArrayList<>();

    public Point2D NORTH_ROOM_COORDINATES;
    public Point2D EAST_ROOM_COORDINATES;
    public Point2D SOUTH_ROOM_COORDINATES;
    public Point2D WEST_ROOM_COORDINATES;

    private static final boolean isSolid = false;
    public static final Image STANDARD_IMAGE = new Image("walkgame/res/map/room.png");

    public boolean visited;

    public Room(Point2D coordinates) {
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
        System.out.println(String.format("Room: %s has been created (%s, %S)", this, this.getX(), this.getY()));

        renderWalls();

        NORTH_ROOM_COORDINATES = new Point2D(super.getX(), super.getY() - super.getHeight());
        EAST_ROOM_COORDINATES = new Point2D(super.getMaxX(), super.getY());
        SOUTH_ROOM_COORDINATES = new Point2D(super.getX(), super.getMaxY());
        WEST_ROOM_COORDINATES =  new Point2D(super.getX() - super.getWidth(), super.getY());

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
                    if(this.contains(room.getSceneHorizontalCenter(), room.getMaxY() + 1))
                    {
                        if(this.roomNorth == null){this.roomNorth = room;}
                    }
                    else if(this.contains(room.getX() - 1, room.getSceneVerticalCenter()))
                    {
                        if(this.roomEast == null){this.roomEast = room;}
                    }
                    else if(this.contains(room.getSceneHorizontalCenter(), room.getY() - 1))
                    {
                        if(this.roomSouth == null){this.roomSouth = room;}
                    }
                    else if(this.contains(room.getMaxX() + 1, room.getSceneVerticalCenter()))
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
                new Door(new Point2D(getX(), getY() + i), this);
            }
            else
            {
                new Wall(new Point2D(getX(), getY() + i), this);
            }
        }

        //right wall
        for (int i = 0; i < super.getWidth() ; i += wallSize) {
            if(i >= screenCenter - 30 && i <= screenCenter + 30)
            {
                new Door(new Point2D(getMaxX() - wallSize, getY() + i), this);
            }
            else
            {
                new Wall(new Point2D(getMaxX() - wallSize, getY() + i), this);
            }
        }

        //top wall
        for (int i = 0; i < super.getWidth() ; i += wallSize) {
            if(i >= screenCenter - 30 && i <= screenCenter + 30)
            {
                new Door(new Point2D(getX() + i, getY()), this);
            }
            else{
                new Wall(new Point2D(getX() + i, getY()), this);
            }
        }

        //bottom wall
        for (int i = 0; i < super.getWidth() ; i += wallSize) {
            if(i >= screenCenter - 30 && i <= screenCenter + 30)
            {
                new Door(new Point2D(getX() + i, getMaxY() - wallSize), this);
            }
            else{
                new Wall(new Point2D(getX() + i, getMaxY() - wallSize), this);
            }
        }
    }

    /**
     * Compares the parameter with all Sollid objects in this room
     * @param moveableNode A Moveable object that can be compared
     * @return velocityX and VelocityY
     */
    public ArrayList<Character> getCollisionWith(Moveable moveableNode)
    {
        double velocityX = moveableNode.getVelocityX();
        double velocityY = moveableNode.getVelocityY();

        ArrayList<Character> direction = new ArrayList<>();

        for (ImageViewObject sollidNode : sollidObjects)//todo: player kan via deur vast zitten in de muur.
        {
            if(!sollidNode.equals(moveableNode) && sollidNode.isSolid())
            {
                //North
                if(moveableNode.contains(sollidNode.getX() , sollidNode.getMaxY() + velocityY) && !direction.contains(Compass.NORTH))
                {
                    direction.add(Compass.NORTH);
                }
                //East
                if(moveableNode.contains(sollidNode.getX() + velocityX, sollidNode.getY()) && !direction.contains(Compass.EAST))
                {
                    direction.add(Compass.EAST);
                }
                //South
                if(moveableNode.contains(sollidNode.getX() , sollidNode.getY() + velocityY) && !direction.contains(Compass.SOUTH))
                {
                    direction.add(Compass.SOUTH);
                }
                //West
                if(moveableNode.contains(sollidNode.getMaxX() + velocityX, sollidNode.getMaxY()) && !direction.contains(Compass.WEST))
                {
                    direction.add(Compass.WEST);
                }
                if(direction.size() >= 2)
                {
                    break;
                }
            }
        }
        return direction;
    }

    public boolean hasCollisionWith(Moveable moveableNode)
    {
        return getCollisionWith(moveableNode).size() >= 1;
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
