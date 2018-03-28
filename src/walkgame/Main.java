package walkgame;

import gameloop.GameLoop;
import javafx.application.Application;
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

    /*
    *
    * todo: Gameobject interface maken, alle javafx files inheriten in nieuwe classen met gameobject interface
    * todo: objecten hebben stattic groups waar ze zelf in opslaan, die groups worden aan het begin al aan root/type gelinked, hierdoor geen interface meer nodig die type aangeeft
    * todo: de map heeft 4 map propetys + een boolean die checkt of de player er voor het eerst is.
    *
    * */

    public static void main(String[] args) {
        launch(args);
    }
}
