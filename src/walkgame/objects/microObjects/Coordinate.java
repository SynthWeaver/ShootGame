package walkgame.objects.microObjects;

public class Coordinate {

    private static final Coordinate DEFAULT_COORDINATE = new Coordinate(0,0);

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(Coordinate c) {
        this.x = c.getX();
        this.y = c.getY();
    }

    public Coordinate() {
        this(DEFAULT_COORDINATE);
    }

    private double y;
    private double x;


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
}
