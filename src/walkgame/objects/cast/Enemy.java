package walkgame.objects.cast;

import walkgame.interfaces.stage.InCast;
import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.Sprites;
import walkgame.objects.parentClasses.Character;

public class Enemy extends Character implements InCast
{
    public Enemy(Coordinates coordinates, Sprites sprites, int health, double speed) {
        super(sprites, coordinates, health, speed);
    }
}
