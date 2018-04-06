package walkgame.objects.hud;

import javafx.geometry.Point2D;
import walkgame.views.parentClasses.MainView;

public class Hud {
    public static Point2D hudToMovableGroup(Point2D point2D)
    {
        //Point2D movableGroupPoint2D = MainView.getMovableGroup().getPoint2D();
        return point2D.subtract(MainView.getMovableGroup().getPoint2D());
    }
}
