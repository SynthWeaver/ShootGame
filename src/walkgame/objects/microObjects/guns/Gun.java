package walkgame.objects.microObjects.guns;

import javafx.beans.property.SimpleIntegerProperty;
import walkgame.objects.microObjects.Coordinates;

public abstract class Gun {

    private String name;
    private SimpleIntegerProperty ammoCount;

    private int clipSize;
    private SimpleIntegerProperty clipAmmo;

    private double reloadTime;

    protected boolean shooting;


    public Gun(String name, SimpleIntegerProperty ammoCount, int clipSize, double reloadTime) {
        this.name = name;
        this.ammoCount = ammoCount;
        this.clipSize = clipSize;
        this.clipAmmo = new SimpleIntegerProperty(clipSize);
        this.reloadTime = reloadTime;

        this.shooting = false;
    }

    public abstract void shoot(Coordinates gunCoordinates, Coordinates directionCoordinates);

    public abstract void releaseTrigger();

    abstract void shootBullet(Coordinates gunCoordinates, Coordinates directionCoordinates);

    protected void removeBulletFromClip()
    {
        int tmpClipAmmo = this.clipAmmo.get();
        this.clipAmmo.set(--tmpClipAmmo);
    }

    public void reload()
    {
        this.clipAmmo.set(this.clipSize);

        int tmpAmmoCount = this.ammoCount.get();
        tmpAmmoCount -= this.clipSize;
        this.ammoCount.set(tmpAmmoCount);
    }

    public String getName() {
        return name;
    }

    public SimpleIntegerProperty getAmmoCount() {
        return ammoCount;
    }

    protected int getClipSize() {
        return clipSize;
    }

    public SimpleIntegerProperty getClipAmmo() {
        return clipAmmo;
    }

    public double getReloadTime() {
        return reloadTime;
    }

    protected boolean isShooting() {
        return shooting;
    }

    protected void setAmmoCount(int ammoCount) {
        this.ammoCount.set(ammoCount);
    }

    protected void setClipAmmo(int clipAmmo) {
        this.clipAmmo.set(clipAmmo);
    }

    protected void setShooting(boolean shooting) {
        this.shooting = shooting;
    }
}
