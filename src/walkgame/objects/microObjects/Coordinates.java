package walkgame.objects.microObjects;

import javafx.scene.image.Image;
import walkgame.exceptions.CloneException;
import walkgame.interfaces.Moveable;
import walkgame.views.parentClasses.MainView;

public class Coordinates {
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

    public Coordinates(Image image) {
        this.x = image.getWidth();
        this.y = image.getHeight();
    }

    public Coordinates() {
        this(DEFAULT_COORDINATES);
    }

    /**
      * @return Coordinate from hud in movableGroup format
     */
    public Coordinates getRelativisedHudCoordinate()
    {
        return new Coordinates(getX() - MainView.getMovableGroup().getX(), getY() - MainView.getMovableGroup().getY());
    }

    public void add(Coordinates coordinates)
    {
        this.x += coordinates.x;
        this.y += coordinates.y;
    }

    public void minus(Coordinates coordinates)
    {
        this.x -= coordinates.x;
        this.y -= coordinates.y;
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

    public static Coordinates cloneFromObject(Object object) throws CloneException
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
        double myY = getPositionY();
        double theirX = c.getX();
        double theirY = c.getPositionY();

        //if(myY > FirstMainView.screenCenter.getX() && )
    }*/
}
