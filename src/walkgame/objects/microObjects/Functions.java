package walkgame.objects.microObjects;

public class Functions {
    public static double getAngle(Coordinates start, Coordinates target ) {
        double angle = Math.toDegrees(Math.atan2(target.getY() - start.getY(), target.getX() - start.getX()));
        angle += 90;


        if(angle < 0){
            angle += 360;
        }

        return angle;
    }
}
