package walkgame.objects.cast;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Group;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.Sprites;
import walkgame.objects.parentClasses.Character;

public abstract class Enemy extends Character
{
    public static Group group = new Group();//todo: enemies fixen

    public Enemy(Coordinates coordinates, Sprites sprites, SimpleIntegerProperty health, double speed) {
        super(sprites, coordinates, health, speed);
    }

    @Override
    public void addNodeToList()
    {
        Enemy.group.getChildren().add(this);
    }
}
