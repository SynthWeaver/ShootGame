package walkgame.objects.microObjects;

import javafx.scene.image.Image;

public class Sprites {
    private Image spriteNorth, spriteNorthEast, spriteEast, spriteSouthEast, spriteSouth, spriteSouthWest, spriteWest, spriteNorthWest;

    public Sprites(Image spriteNorth, Image spriteNorthEast, Image spriteEast, Image spriteSouthEast, Image spriteSouth, Image spriteSouthWest, Image spriteWest, Image spriteNorthWest) {
        this.spriteNorth = spriteNorth;
        this.spriteNorthEast = spriteNorthEast;
        this.spriteEast = spriteEast;
        this.spriteSouthEast = spriteSouthEast;
        this.spriteSouth = spriteSouth;
        this.spriteSouthWest = spriteSouthWest;
        this.spriteWest = spriteWest;
        this.spriteNorthWest = spriteNorthWest;
    }

    public Image getSprite(int direction) {
        switch (direction)
        {
            case Coordinates.NORTH: return spriteNorth;
            case Coordinates.NORTH_EAST: return spriteNorthEast;
            case Coordinates.EAST: return spriteEast;
            case Coordinates.SOUTH_EAST: return spriteSouthEast;
            case Coordinates.SOUTH: return spriteSouth;
            case Coordinates.SOUTH_WEST: return spriteSouthWest;
            case Coordinates.WEST: return spriteWest;
            case Coordinates.NORTH_WEST: return spriteNorthWest;
            default: return spriteSouth;
        }
    }

    public void setSpriteNorth(Image spriteNorth) {
        this.spriteNorth = spriteNorth;
    }

    public void setSpriteNorthEast(Image spriteNorthEast) {
        this.spriteNorthEast = spriteNorthEast;
    }

    public void setSpriteEast(Image spriteEast) {
        this.spriteEast = spriteEast;
    }

    public void setSpriteSouthEast(Image spriteSouthEast) {
        this.spriteSouthEast = spriteSouthEast;
    }

    public void setSpriteSouth(Image spriteSouth) {
        this.spriteSouth = spriteSouth;
    }

    public void setSpriteSouthWest(Image spriteSouthWest) {
        this.spriteSouthWest = spriteSouthWest;
    }

    public void setSpriteWest(Image spriteWest) {
        this.spriteWest = spriteWest;
    }

    public void setSpriteNorthWest(Image spriteNorthWest) {
        this.spriteNorthWest = spriteNorthWest;
    }
}
