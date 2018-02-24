package walkgame.objects.parentObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GameObject extends ImageView
{
    public final static ArrayList<Integer> ID_LIST = new ArrayList<>();

    public GameObject(double x, double y, Image image)
    {
        super(image);
        createID();

        super.setX(x);
        super.setY(y);
    }

    private int id;

    private void createID()
    {
        id = ID_LIST.size();
        ID_LIST.add(id);
    }
}
