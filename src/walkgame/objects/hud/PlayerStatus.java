package walkgame.objects.hud;

import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import walkgame.objects.parentClasses.PaneObject;
import walkgame.views.parentClasses.MainView;

public class PlayerStatus extends PaneObject
{
    public static Group group = new Group();

    private static final String BACKGROUND_COLOUR = "-fx-background-color: white;";

    private static final ImageView HEALTH = new ImageView("walkgame/res/ui/hp.png");//todo: images mooier maken
    private static final ImageView AMMO_CLIP = new ImageView("walkgame/res/ui/clip.png");
    private static final ImageView AMMO = new ImageView("walkgame/res/ui/ammo.png");

    private double width = 0.00;
    public PlayerStatus() {
        super(new Point2D(MainView.screenSize.getX(), 0));

        generateHud(loadText());

        super.setX(super.getX() - width);
        super.setStyle(BACKGROUND_COLOUR);
    }

    private Text[] loadText()
    {
        Player player = MainView.getCurrentPlayer();

        Text[] textArray = new Text[]{new Text("0"), new Text("0"), new Text("0")};
        textArray[0].textProperty().bind(player.getHealth().asString());
        textArray[1].textProperty().bind(player.getCurrentGun().getClipAmmo().asString());
        textArray[2].textProperty().bind(player.getCurrentGun().getAmmoCount().asString());

        return textArray;
    }

    private double generateHud(Text[] textArray)
    {
        ImageView[] imageViewArray = new ImageView[]{HEALTH, AMMO_CLIP, AMMO};

        for (int i = 0; i < textArray.length ; i++) {
            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(imageViewArray[i]);
            textArray[i].setFill(Color.WHITE);
            stackPane.getChildren().add(textArray[i]);
            stackPane.setAlignment(Pos.CENTER);

            stackPane.setLayoutX(width);
            width += imageViewArray[i].getImage().getWidth();

            super.getChildren().add(stackPane);
        }

        return width;
    }

    @Override
    public void addNodeToList()
    {
        PlayerStatus.group.getChildren().clear();
        PlayerStatus.group.getChildren().add(0, this);
    }
}
