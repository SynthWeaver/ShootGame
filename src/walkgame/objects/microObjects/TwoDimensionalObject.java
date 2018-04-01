package walkgame.objects.microObjects;

import javafx.scene.image.Image;
import walkgame.objects.parentClasses.ImageViewObject;

public class TwoDimensionalObject//todo omzetten naar point2d + contains
{
    private Double positionX;
    private Double positionY;

    private Double width;
    private Double height;

    public TwoDimensionalObject(Coordinates first, Coordinates width)
    {
        this.positionX = first.getX();
        this.positionY = first.getY();
        this.width = positionX + width.getX();
        this.height = positionY + width.getY();
    }

    public TwoDimensionalObject(Coordinates first, Image image)
    {
        this(first, new Coordinates(image.getWidth(), image.getHeight()));
    }

    public TwoDimensionalObject(Coordinates first, double width, double height)
    {
        this(first, new Coordinates(width, height));
    }

    public TwoDimensionalObject(ImageViewObject object)
    {
        this(object.getCoordinate().getRelativisedHudCoordinate(), new Coordinates(object.getX() + object.getImage().getWidth(), object.getY() + object.getImage().getHeight()).getRelativisedHudCoordinate());
    }

    public Coordinates getCenter()
    {
        double screenCenterX = positionX + (width / 2f);
        double screenCenterY = positionY + (height / 2f);

        return new Coordinates(screenCenterX, screenCenterY);
    }
    
    public boolean checkCollision(TwoDimensionalObject other2dObject)
    {
        if (this.positionY <= other2dObject.getTotalHeight() && this.positionY >= other2dObject.positionY && this.positionX >= other2dObject.positionX && this.getTotalWidth() <= other2dObject.getTotalWidth()) return true;//north collision
        if (this.getTotalWidth() >= other2dObject.positionX && this.getTotalWidth() <= other2dObject.getTotalWidth() && this.positionY >= other2dObject.positionY && this.getTotalHeight() <= other2dObject.getTotalHeight()) return true;//east collision
        if (this.getTotalHeight() >= other2dObject.positionY && this.getTotalHeight() <= other2dObject.getTotalHeight() && this.positionX >= other2dObject.positionX && this.getTotalWidth() <= other2dObject.getTotalWidth()) return true;//south collision
        if (this.positionX <= other2dObject.getTotalWidth() && this.positionX >= other2dObject.positionX && this.positionY >= other2dObject.positionY && this.getTotalHeight() <= other2dObject.getTotalHeight()) return true;//west collision
        return false;
    }

    public double getTotalWidth()
    {
        return positionX + width;
    }

    public double getTotalHeight()
    {
        return positionY + height;
    }

    public Double getPositionX()
    {
        return positionX;
    }

    public void setPositionX(Double positionX)
    {
        this.positionX = positionX;
    }

    public Double getPositionY()
    {
        return positionY;
    }

    public void setPositionY(Double positionY)
    {
        this.positionY = positionY;
    }

    public Double getWidth()
    {
        return width;
    }

    public void setWidth(Double width)
    {
        this.width = width;
    }

    public Double getHeight()
    {
        return height;
    }

    public void setHeight(Double height)
    {
        this.height = height;
    }
}
