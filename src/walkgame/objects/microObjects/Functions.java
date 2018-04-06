package walkgame.objects.microObjects;

import javafx.geometry.Point2D;

public class Functions {
    public static double getAngle(Point2D start, Point2D target ) {
        double angle = Math.toDegrees(Math.atan2(target.getY() - start.getY(), target.getX() - start.getX()));
        angle += 90;

        if(angle < 0){
            angle += 360;
        }

        return angle;
    }
}
