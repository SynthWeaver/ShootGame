package walkgame.objects.cast;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import walkgame.objects.microObjects.Sprites;
import walkgame.objects.parentClasses.Character;
import walkgame.views.parentClasses.MainView;

public abstract class Enemy extends Character
{
    public static Group group = new Group();// todo: enemies fixen

    public Enemy(Point2D coordinates, Sprites sprites, SimpleIntegerProperty health, double speed) {
        super(sprites, coordinates, health, speed);
    }

    @Override
    public void addNodeToList()
    {
        Enemy.group.getChildren().add(this);

        MainView.DESTRUCTIBLE_LIST.add(this);
        MainView.MOVEABLE_LIST.add(this);
    }
}
