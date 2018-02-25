package walkgame.objects.guns;

import java.util.ArrayList;

public abstract class Gun {

    private static ArrayList<Gun> guns = new ArrayList<>();

    private String name;
    private int ammoCount;

    private int clipSize;
    private int bulletID;

    private double rateOfFire;
    private double reach;
    private double reloadTime;

    private boolean automatic;


    public Gun(String name, int ammoCount, int clipSize, int bulletID, double rateOfFire, double reach, double reloadTime, boolean automatic) {
        this.name = name;
        this.ammoCount = ammoCount;
        this.clipSize = clipSize;
        this.bulletID = bulletID;
        this.rateOfFire = rateOfFire;
        this.reach = reach;
        this.reloadTime = reloadTime;
        this.automatic = automatic;

        guns.add(this);
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

    public int getBulletID() {
        return bulletID;
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

    public static Gun getGunByName(String name) {
        for(Gun gun: guns)
        {
            if(gun.name.equals(name))
            {
                return gun;
            }
        }

        return null;
    }

    public void setAmmoCount(int ammoCount) {
        this.ammoCount = ammoCount;
    }
}
