package walkgame;

import gameloop.GameLoop;
import javafx.application.Application;
import javafx.stage.Stage;
import walkgame.views.FirstMainView;

public class Main extends Application {

    public FirstMainView firstView;

    @Override
    public void start(Stage primaryStage){
        firstView = new FirstMainView(primaryStage);
        new GameLoop(firstView.firstViewController).start();

        primaryStage.setScene(firstView.scene);

        primaryStage.setTitle("WalkGame");
        primaryStage.setResizable(false);
        primaryStage.show();
    }//todo: add class with engine options (van boven of zijkant etc).

    public static void main(String[] args) {
        launch(args);
    }
}
