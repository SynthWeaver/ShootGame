package walkgame.objects.microObjects;

import walkgame.exceptions.CloneException;
import walkgame.interfaces.Moveable;
import walkgame.views.parentClasses.MainView;

public class Coordinates {
    public static final int NORTH = 0, NORTH_NORTH_EAST = 23 , NORTH_EAST = 45, NORTH_EAST_EAST = 68, EAST = 90, SOUTH_EAST_EAST = 113,  SOUTH_EAST = 135, SOUTH_SOUTH_EAST = 158, SOUTH = 180, SOUTH_SOUTH_WEST = 203, SOUTH_WEST = 225, SOUTH_WEST_WEST = 248,  WEST = 270, NORTH_WEST_WEST = 293, NORTH_WEST = 315, NORTH_NORTH_WEST = 338;
    private static final Coordinates DEFAULT_COORDINATES = new Coordinates(0,0);

    private double y;
    private double x;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(Coordinates c) {
        this.x = c.getX();
        this.y = c.getY();
    }

    public Coordinates() {
        this(DEFAULT_COORDINATES);
    }

    public void relativiseCoordinates()
    {
        Coordinates movableGroup;
        try {
            movableGroup = Coordinates.cloneCordinates(MainView.getMovableGroup());
        } catch (CloneException e) {
            e.printStackTrace();
            return;
        }

        movableGroup.x *= -1;
        movableGroup.y *= -1;

        this.x += movableGroup.getX();
        this.y += movableGroup.getY();
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public static Coordinates cloneCordinates(Object object) throws CloneException
    {
        if(object instanceof Moveable)
        {
            return new Coordinates(((Moveable) object).getCoordinate());
        }
        else {
            throw new CloneException("parameter object is not Moveable");
        }
    }

    /*private int compare(Coordinates c)
    {
        double myX = getX();
        double myY = getY();
        double theirX = c.getX();
        double theirY = c.getY();

        //if(myY > FirstMainView.screenCenter.getX() && )
    }*/
}
