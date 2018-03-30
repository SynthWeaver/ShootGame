package walkgame;

import gameloop.GameLoop;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.stage.Stage;
import walkgame.views.FirstMainView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        FirstMainView firstView = new FirstMainView(primaryStage);
        new GameLoop(firstView.firstViewController).start();

        primaryStage.setScene(firstView.scene);

        primaryStage.setTitle("WalkGame");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
