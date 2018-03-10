package walkgame.objects.UI;

import gameloop.GameLoop;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import walkgame.interfaces.ListableNode;
import walkgame.objects.Player;
import walkgame.views.parentClasses.MainView;

public class PlayerStatus extends Pane implements ListableNode{

    private static final ImageView HEALTH = new ImageView("walkgame/res/ui/hp.png");
    private static final ImageView AMMO_CLIP = new ImageView("walkgame/res/ui/clip.png");
    private static final ImageView AMMO = new ImageView("walkgame/res/ui/ammo.png");

    private Text healthLabel = new Text();
    private Text ammoClipLabel = new Text();
    private Text ammoLabel = new Text();

    private double currentWidth = 0.00;

    public PlayerStatus(Player player) {
        healthLabel.textProperty().bind(player.healthProperty.asString());
        ammoClipLabel.textProperty().bind(player.ammoClipProperty.asString());
        ammoLabel.textProperty().bind(player.ammoProperty.asString());

        placePlayerStatus();
        setThisPaneLocation(MainView.screenSize.getX() - currentWidth, 0.00);
        //updatePlayerStatus(player);
        super.setStyle("-fx-background-color: white;");


        addNodeToList();
    }

    private void setThisPaneLocation(Double x, Double y)
    {
        super.setLayoutX(x);
        super.setLayoutY(y);
    }

    private void placePlayerStatus()
    {
        //todo add vbox
        Text[] textArray = new Text[]{healthLabel, ammoClipLabel, ammoLabel};
        ImageView[] imageViewArray = new ImageView[]{HEALTH, AMMO_CLIP, AMMO};

        for (int i = 0; i < textArray.length ; i++) {
            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(imageViewArray[i]);
            textArray[i].setFill(Color.WHITE);
            stackPane.getChildren().add(textArray[i]);
            stackPane.setAlignment(Pos.CENTER);

            stackPane.setLayoutX(currentWidth);

            currentWidth += imageViewArray[i].getImage().getWidth();


            super.getChildren().add(stackPane);
        }
    }

    public void updatePlayerStatus(Player player)
    {
        player.getHealth();

        this.healthLabel.textProperty();

        this.healthLabel.setText(String.valueOf(player.getHealth()));
        this.ammoClipLabel.setText(String.valueOf(player.getCurrentGun().getClipAmmo()));
        this.ammoLabel.setText(String.valueOf(player.getCurrentGun().getAmmoCount()));
    }

    @Override
    public void addNodeToList()
    {
        MainView.nodeList.add(this);
        GameLoop.doLogicUpdate();
    }
}
