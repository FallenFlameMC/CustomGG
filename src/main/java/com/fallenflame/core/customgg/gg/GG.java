package com.fallenflame.core.customgg.gg;

import java.util.UUID;

public class GG {

    private char color;
    private boolean isBold;
    private boolean isUnderline;
    private boolean isItalic;
    private boolean isStrike;
    private boolean hasBars;
    private UUID owner;
    private String gg;

    public GG(UUID owner, char color, boolean isBold, boolean isUnderline, boolean isItalic, boolean isStrike, boolean hasBars) {
        this.owner = owner;
        this.color = color;
        this.isBold = isBold;
        this.isUnderline = isUnderline;
        this.isItalic = isItalic;
        this.isStrike = isStrike;
        this.hasBars = hasBars;
    }

    public GG(UUID owner) {
        this.owner = owner;
        this.color = 'f';
        this.isBold = false;
        this.isUnderline = false;
        this.isItalic = false;
        this.isStrike = false;
        this.hasBars = false;
    }

    public UUID getOwner() {
        return owner;
    }
    public char getColor() {
        return color;
    }
    public boolean isBold() {
        return isBold;
    }
    public boolean isUnderline() {
        return isUnderline;
    }
    public boolean isItalic() {
        return isItalic;
    }
    public boolean isStrike() {
        return isStrike;
    }
    public boolean isHasBars() {
        return hasBars;
    }
    public String getGG() {
        return gg;
    }
    public void setColor(char color) {
        this.color = color;
    }

    public void setBold(boolean bold) {
        isBold = bold;
    }
    public void setUnderline(boolean underline) {
        isUnderline = underline;
    }
    public void setItalic(boolean italic) {
        isItalic = italic;
    }
    public void setStrike(boolean strike) {
        isStrike = strike;
    }
    public void setHasBars(boolean hasBars) {
        this.hasBars = hasBars;
    }

    @Override
    public String toString() {
        return "com.fallenflame.core.customgg.gg.GG[gg=" + gg + ",owner=" + owner.toString() + "]";
    }
}
