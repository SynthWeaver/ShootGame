package walkgame.objects.hud;

import javafx.geometry.Point2D;
import walkgame.views.parentClasses.MainView;

public class Hud {
    public static Point2D hudToMovableGroup(Point2D point2D)
    {
        return point2D.subtract(MainView.getMovableGroup().getPoint2D());
    }

    public static Point2D hudToMovableGroup(double x, double y)
    {
        return Hud.hudToMovableGroup(new Point2D(x, y));
    }
}
