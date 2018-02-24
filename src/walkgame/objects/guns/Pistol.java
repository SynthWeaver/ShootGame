package walkgame.objects.guns;

import javafx.scene.image.ImageView;
import views.View;

public class Pistol extends Gun {
    public Pistol() {
        super("Pistol", 9, 0, new ImageView(), 1, View.SCREEN_HEIGHT, 3, false);
    }
}
