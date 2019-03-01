package com.qianfanyun.lib;


import android.widget.ImageView;

import com.qianfanyun.lib.base.BaseImageLoaderStrategy;
import com.qianfanyun.lib.glide.GlideImageLoaderStrategy;

/**
 * @author ArcherYc
 * @date on 2019/2/28  3:40 PM
 * @mail 247067345@qq.com
 */
public class ImageLoader {

    private static ImageLoader mInstance;
    private BaseImageLoaderStrategy mImageLoaderStrategy;

    private ImageLoader() {
        if (mImageLoaderStrategy == null) {
            mImageLoaderStrategy = new GlideImageLoaderStrategy();
        }
    }

    public static ImageLoader get() {
        if (mInstance == null) {
            synchronized (ImageLoader.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoader();
                    return mInstance;
                }
            }
        }
        return mInstance;
    }

    public void loadImage(ImageView imageView, String url, ImageOptions imageOptions) {
        mImageLoaderStrategy.loadImage(imageView, url, imageOptions);
    }

    public void loadImage(ImageView imageView, String url) {
        mImageLoaderStrategy.loadImage(imageView, url);
    }

    public void setImageLoaderStrategy(BaseImageLoaderStrategy imageLoaderStrategy) {
        this.mImageLoaderStrategy = imageLoaderStrategy;
    }
}
