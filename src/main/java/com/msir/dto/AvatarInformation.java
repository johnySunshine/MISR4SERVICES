package com.msir.dto;

/**
 * Created by Fantasy on 2017/2/17.
 */
public class AvatarInformation {
    private String avatarSrc, avatarOption, avatarFile, offsetX, offsetY, avatarWidth, avatarHeight;
    private boolean avatarIsCut;

    public String getAvatarSrc() {
        return avatarSrc;
    }

    public void setAvatarSrc(String avatarSrc) {
        this.avatarSrc = avatarSrc;
    }

    public String getAvatarOption() {
        return avatarOption;
    }

    public void setAvatarOption(String avatarOption) {
        this.avatarOption = avatarOption;
    }

    public String getAvatarFile() {
        return avatarFile;
    }

    public void setAvatarFile(String avatarFile) {
        this.avatarFile = avatarFile;
    }

    public String getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(String offsetX) {
        this.offsetX = offsetX;
    }

    public String getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(String offsetY) {
        this.offsetY = offsetY;
    }

    public String getAvatarWidth() {
        return avatarWidth;
    }

    public void setAvatarWidth(String avatarWidth) {
        this.avatarWidth = avatarWidth;
    }

    public String getAvatarHeight() {
        return avatarHeight;
    }

    public void setAvatarHeight(String avatarHeight) {
        this.avatarHeight = avatarHeight;
    }

    public boolean isAvatarIsCut() {
        return avatarIsCut;
    }

    public void setAvatarIsCut(boolean avatarIsCut) {
        this.avatarIsCut = avatarIsCut;
    }
}
