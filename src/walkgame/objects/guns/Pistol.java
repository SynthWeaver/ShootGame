package walkgame.objects.guns;

import views.View;
import walkgame.objects.bullets.Bullet;
import walkgame.objects.bullets.PistolBullet;
import walkgame.objects.microObjects.Coordinates;

public class Pistol extends Gun {

    public Pistol() {
        super("Pistol", 9, 0, 1, View.SCREEN_HEIGHT, 3, false);
    }

    @Override
    public void shoot(Coordinates gunCoordinates, Coordinates directionCoordinates)
    {
        new PistolBullet(gunCoordinates, directionCoordinates);
    }
}
