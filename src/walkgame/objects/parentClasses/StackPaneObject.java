package walkgame.objects.parentClasses;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import walkgame.interfaces.ObjectInGame;

public abstract class StackPaneObject extends StackPane implements ObjectInGame
{
    public StackPaneObject(Point2D point2D)
    {
        super();
        innit(point2D);
    }

    public StackPaneObject(Image[] images, Point2D point2D)
    {
        super();
        innit(point2D);

        //final StackPane container = new StackPane();
        for(Image image: images) {
            super.getChildren().add(new ImageView(image));
        }

        //super.getChildren().add(container);
    }

    private void innit(Point2D point2D)
    {
        this.setX(point2D.getX());
        this.setY(point2D.getY());

        addNodeToList();
    }

    @Override
    public double getX() {
        return super.getLayoutX();
    }

    @Override
    public double getY() {
        return super.getLayoutY();
    }

    @Override
    public Point2D getPoint2D()
    {
        Point2D point2D = new Point2D(this.getX(), this.getY());
        return point2D;
    }

    @Override
    public Point2D getMaxPoint2D()
    {
        Point2D point2D = new Point2D(this.getMaxX(), this.getMaxY());
        return point2D;
    }

    public double getRealWidth()
    {
        return super.getBoundsInParent().getWidth();
    }

    public double getRealHeight()
    {
        return super.getBoundsInParent().getHeight();
    }

    @Override
    public Point2D getSize()
    {
        return new Point2D(this.getRealWidth(), this.getRealHeight());
    }

    @Override
    public double getMaxX()
    {
        return this.getX() + getWidth();
    }

    @Override
    public double getMaxY()
    {
        return this.getY() + getHeight();
    }

    @Override
    public double getSceneHorizontalCenter()
    {
        return getX() + (getWidth() / 2f);
    }

    @Override
    public double getSceneVerticalCenter()
    {
        return getY() + (getHeight() / 2f);
    }

    @Override
    public Point2D getCenter()
    {
        return new Point2D(getSceneHorizontalCenter(), getSceneVerticalCenter());
    }

    @Override
    public Image getImage() {
        double size = 0;
        Image finalImage = null;
        for(Node node: super.getChildren()) {
            if(node instanceof ImageView)
            {
                Image image = ((ImageView)node).getImage();
                if(image.getHeight() > size || image.getWidth() > size)
                {
                    finalImage = image;
                }
            }
        }
        if(finalImage == null)
        {
            throw new NullPointerException(String.format("Object '%s' has no images", this));
        }
        return finalImage;
    }

    @Override
    public void setX(double x) {
        super.setLayoutX(x);
    }

    @Override
    public void setY(double y) {
        super.setLayoutY(y);
    }

    @Override
    public abstract void addNodeToList();
}
