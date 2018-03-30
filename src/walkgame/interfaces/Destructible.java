package walkgame.interfaces;

import javafx.beans.property.SimpleIntegerProperty;

public interface Destructible
{
    void setHealth(int health);
    SimpleIntegerProperty getHealth();
    void destroy();
}
