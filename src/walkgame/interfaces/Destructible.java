package walkgame.interfaces;

import javafx.beans.property.SimpleIntegerProperty;

public interface Destructible
{
    void setHealth(int health);
    SimpleIntegerProperty getHealth();
    void destroy();//Dont forget to send message (System.out.println(String.format("Object %s has been destroyed", this));)
}
