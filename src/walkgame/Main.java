package walkgame;

import javafx.application.Application;
import javafx.stage.Stage;
import walkgame.views.FirstView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        FirstView firstView = new FirstView(primaryStage);

        primaryStage.setScene(firstView.scene);

        primaryStage.setTitle("WalkGame");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
