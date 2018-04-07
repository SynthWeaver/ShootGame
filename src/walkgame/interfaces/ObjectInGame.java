package walkgame.interfaces;


import javafx.scene.image.Image;

public interface ObjectInGame extends Boundable
{
    Image getImage();
    void addNodeToList();
}
