package walkgame.objects.microObjects.guns;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public abstract class Gun {//todo: meer guns en ammo

    private String name;
    private Image image;
    private SimpleIntegerProperty ammoCount;

    private int clipSize;
    private SimpleIntegerProperty clipAmmo;

    private double reloadTime;

    protected boolean shooting;


    public Gun(String name, Image image, SimpleIntegerProperty ammoCount, int clipSize, double reloadTime) {
        this.name = name;
        this.image = image;
        this.ammoCount = ammoCount;
        this.clipSize = clipSize;
        this.clipAmmo = new SimpleIntegerProperty(clipSize);
        this.reloadTime = reloadTime;

        this.shooting = false;
    }

    public abstract void shoot(Point2D gunCoordinates, Point2D directionCoordinates);

    public abstract void releaseTrigger();

    abstract void shootBullet(Point2D gunCoordinates, Point2D directionCoordinates);

    protected void removeBulletFromClip()
    {
        if(this.clipAmmo.get() >= 1)
        {
            int tmpClipAmmo = this.clipAmmo.get();
            this.clipAmmo.set(--tmpClipAmmo);
        }
    }

    public void reload()
    {
        if(this.ammoCount.get() >= this.clipSize && this.clipAmmo.get() < this.clipSize) {
            this.clipAmmo.set(this.clipSize);

            int tmpAmmoCount = this.ammoCount.get();
            tmpAmmoCount -= this.clipSize;
            this.ammoCount.set(tmpAmmoCount);
        }
        else if (this.ammoCount.get() >= 1 && this.clipAmmo.get() < this.clipSize)
        {
            this.clipAmmo.set(this.ammoCount.get());
            this.ammoCount.set(0);
        }
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
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
