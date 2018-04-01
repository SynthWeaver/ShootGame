package walkgame.objects.microObjects;

import walkgame.objects.parentClasses.ImageViewObject;

public class TwoDimensionalObject//todo omzetten naar point2d + contains
{
    private Double x1;
    private Double y1;

    private Double x2;
    private Double y2;

    public TwoDimensionalObject(Coordinates first, Coordinates second)
    {
        this.x1 = first.getX();
        this.y1 = first.getY();
        this.x2 = second.getX();
        this.y2 = second.getY();
    }

    public TwoDimensionalObject(ImageViewObject object)
    {
        this(object.getCoordinate().getRelativisedHudCoordinate(), new Coordinates(object.getX() + object.getImage().getWidth(), object.getY() + object.getImage().getHeight()).getRelativisedHudCoordinate());
    }

    public Coordinates getScreenCenter()
    {
        double diffX = x2 - x1;
        double diffY = y2 - y1;

        double screenCenterX = x1 + (diffX / 2f);
        double screenCenterY = y1 + (diffY / 2f);

        return new Coordinates(screenCenterX, screenCenterY);
    }
    
    public boolean checkCollision(TwoDimensionalObject other2dObject)
    {
        if (this.y1 <= other2dObject.y2 && this.y1 >= other2dObject.y1 && this.x1 >= other2dObject.x1 && this.x2 <= other2dObject.x2) return true;//north collision
        if (this.x2 >= other2dObject.x1 && this.x2 <= other2dObject.x2 && this.y1 >= other2dObject.y1 && this.y2 <= other2dObject.y2) return true;//east collision
        if (this.y2 >= other2dObject.y1 && this.y2 <= other2dObject.y2 && this.x1 >= other2dObject.x1 && this.x2 <= other2dObject.x2) return true;//south collision
        if (this.x1 <= other2dObject.x2 && this.x1 >= other2dObject.x1 && this.y1 >= other2dObject.y1 && this.y2 <= other2dObject.y2) return true;//west collision
        return false;
    }

    public Double getX1()
    {
        return x1;
    }

    public void setX1(Double x1)
    {
        this.x1 = x1;
    }

    public Double getY1()
    {
        return y1;
    }

    public void setY1(Double y1)
    {
        this.y1 = y1;
    }

    public Double getX2()
    {
        return x2;
    }

    public void setX2(Double x2)
    {
        this.x2 = x2;
    }

    public Double getY2()
    {
        return y2;
    }

    public void setY2(Double y2)
    {
        this.y2 = y2;
    }
}
