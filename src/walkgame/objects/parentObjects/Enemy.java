package walkgame.objects.parentObjects;

import walkgame.objects.microObjects.Coordinates;
import walkgame.objects.microObjects.Sprites;

public class Enemy extends Character
{
    public Enemy(Coordinates coordinates, Sprites sprites, int health, double speed) {
        super(sprites, coordinates, health, speed);
    }
}
