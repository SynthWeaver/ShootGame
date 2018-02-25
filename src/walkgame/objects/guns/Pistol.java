package walkgame.objects.guns;

import views.View;
import walkgame.objects.bullets.Bullet;

public class Pistol extends Gun {

    public Pistol() {
        super("Pistol", 9, 0, Bullet.PISTOL_BULLET_ID, 1, View.SCREEN_HEIGHT, 3, false);
    }
}
