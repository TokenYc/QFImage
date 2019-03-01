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

    public ImageOptions(int placeholderId, int errorId, boolean circleCrop, Drawable placeholderDrawable, Drawable errorDrawable) {
        this.placeholderId = placeholderId;
        this.errorId = errorId;
        this.circleCrop = circleCrop;
        this.placeholderDrawable = placeholderDrawable;
        this.errorDrawable = errorDrawable;
    }

    public static ImageOptions.Builder option() {
        return new Builder();
    }

    public static final class Builder {

        private int placeholderId;
        private int errorId;
        private boolean circleCrop;
        private Drawable placeholderDrawable;
        private Drawable errorDrawable;


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

        public ImageOptions build() {
            return new ImageOptions(placeholderId, errorId, circleCrop, placeholderDrawable, errorDrawable);
        }

    }

}
