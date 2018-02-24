package walkgame.objects.guns;

import javafx.scene.image.ImageView;

public class Gun {

    private String name;
    private int clipSize;
    private int ammoCount;
    private ImageView bullet;

    private double rateOfFire;
    private double reach;
    private double reloadTime;

    private boolean automatic;


    public Gun(String name, int clipSize, int ammoCount, ImageView bullet, double rateOfFire, double reach, double reloadTime, boolean automatic) {
        this.name = name;
        this.clipSize = clipSize;
        this.ammoCount = ammoCount;
        this.bullet = bullet;
        this.rateOfFire = rateOfFire;
        this.reach = reach;
        this.reloadTime = reloadTime;
        this.automatic = automatic;
    }

    public Gun()
    {
        this.name = "None";
        this.clipSize = 0;
        this.ammoCount = 0;
        this.bullet = new ImageView();
        this.rateOfFire = 0;
        this.reach = 0;
        this.reloadTime = 0;
        this.automatic = false;
    }

    public String getName() {
        return name;
    }

    public int getClipSize() {
        return clipSize;
    }

    public int getAmmoCount() {
        return ammoCount;
    }

    public ImageView getBullet() {
        return bullet;
    }

    public double getRateOfFire() {
        return rateOfFire;
    }

    public double getReach() {
        return reach;
    }

    public double getReloadTime() {
        return reloadTime;
    }

    public boolean isAutomatic() {
        return automatic;
    }
}
