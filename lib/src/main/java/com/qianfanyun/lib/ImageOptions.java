package com.qianfanyun.lib;

import android.graphics.drawable.Drawable;

/**
 * @author ArcherYc
 * @date on 2019/2/28  4:17 PM
 * @mail 247067345@qq.com
 */
public class ImageOptions {
    private int placeholderId;
    private Drawable placeholderDrawable;
    private int errorId;
    private Drawable errorDrawable;
    private boolean circleCrop;
    private boolean centerCrop;
    private int roundCorner;
    private int overrideWidth;
    private int overrideHeight;


    public int getPlaceholderId() {
        return placeholderId;
    }

    public int getErrorId() {
        return errorId;
    }


    public Drawable getPlaceholderDrawable() {
        return placeholderDrawable;
    }

    public Drawable getErrorDrawable() {
        return errorDrawable;
    }

    public boolean isCircleCrop() {
        return circleCrop;
    }

    public int getRoundCorner() {
        return roundCorner;
    }

    public int getOverrideWidth() {
        return overrideWidth;
    }

    public int getOverrideHeight() {
        return overrideHeight;
    }

    public boolean isCenterCrop() {
        return centerCrop;
    }

    public ImageOptions(int placeholderId, int errorId, boolean circleCrop, boolean centerCrop, Drawable placeholderDrawable, Drawable errorDrawable, int roundCorner
            , int overrideWidth, int overrideHeight) {
        this.placeholderId = placeholderId;
        this.errorId = errorId;
        this.circleCrop = circleCrop;
        this.centerCrop = centerCrop;
        this.placeholderDrawable = placeholderDrawable;
        this.errorDrawable = errorDrawable;
        this.roundCorner = roundCorner;
        this.overrideWidth = overrideWidth;
        this.overrideHeight = overrideHeight;
    }

    public static ImageOptions.Builder option() {
        return new Builder();
    }

    public static final class Builder {

        private int placeholderId;
        private int errorId;
        private boolean circleCrop;
        private boolean centerCrop;
        private Drawable placeholderDrawable;
        private Drawable errorDrawable;
        private int roundCorner;
        private int overrideWidth;
        private int overrideHeight;


        public Builder placeholder(int resId) {
            this.placeholderId = resId;
            this.placeholderDrawable = null;
            return this;
        }

        public Builder placeholder(Drawable placeholderDrawable) {
            this.placeholderDrawable = placeholderDrawable;
            this.placeholderId = 0;
            return this;
        }

        public Builder error(int resId) {
            this.errorId = resId;
            this.errorDrawable = null;
            return this;
        }

        public Builder error(Drawable drawable) {
            this.errorDrawable = drawable;
            this.errorId = 0;
            return this;
        }


        public Builder circleCrop() {
            this.circleCrop = true;
            return this;
        }

        public Builder centerCrop() {
            this.centerCrop = true;
            return this;
        }

        public Builder roundCorner(int corner) {
            this.roundCorner = corner;
            return this;
        }

        public Builder override(int width, int height) {
            this.overrideWidth = width;
            this.overrideHeight = height;
            return this;
        }

        public ImageOptions build() {
            return new ImageOptions(placeholderId, errorId, circleCrop, centerCrop, placeholderDrawable, errorDrawable, roundCorner,
                    overrideWidth, overrideHeight);
        }

    }

}
