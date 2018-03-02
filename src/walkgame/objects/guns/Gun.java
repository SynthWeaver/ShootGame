package walkgame.objects.guns;

import walkgame.objects.microObjects.Coordinates;

public abstract class Gun {

    private String name;
    private int ammoCount;

    private int clipSize;
    private int clipAmmo;

    private double rateOfFire;
    private double reloadTime;

    protected boolean shooting;


    public Gun(String name, int ammoCount, int clipSize, double rateOfFire, double reloadTime) {
        this.name = name;
        this.ammoCount = ammoCount;
        this.clipSize = clipSize;
        this.clipAmmo = clipSize;
        this.rateOfFire = rateOfFire;
        this.reloadTime = reloadTime;

        this.shooting = false;
    }

    public abstract void shoot(Coordinates gunCoordinates, Coordinates directionCoordinates);

    public abstract void releaseTrigger();

    abstract void shootBullet(Coordinates gunCoordinates, Coordinates directionCoordinates);

    public String getName() {
        return name;
    }

    public int getAmmoCount() {
        return ammoCount;
    }

    protected int getClipSize() {
        return clipSize;
    }

    public int getClipAmmo() {
        return clipAmmo;
    }

    protected double getRateOfFire() {
        return rateOfFire;
    }

    public double getReloadTime() {
        return reloadTime;
    }

    protected boolean isShooting() {
        return shooting;
    }

    protected void setAmmoCount(int ammoCount) {
        this.ammoCount = ammoCount;
    }

    protected void setClipAmmo(int clipAmmo) {
        this.clipAmmo = clipAmmo;
    }

    protected void setShooting(boolean shooting) {
        this.shooting = shooting;
    }
}
