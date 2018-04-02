package test.Game;

import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import walkgame.views.FirstMainView;

class FirstMainViewTest {

    FirstMainView firstMainView;

    @BeforeEach
    void setUp() {
        firstMainView = new FirstMainView(new Stage());
    }
}