package com.qianfanyun.lib;


import android.net.Uri;
import android.widget.ImageView;

import com.qianfanyun.lib.base.BaseImageLoaderStrategy;
import com.qianfanyun.lib.glide.GlideImageLoaderStrategy;

import java.io.File;

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

    public void loadImage(ImageView imageView, int resId, ImageOptions imageOptions) {
        mImageLoaderStrategy.loadImage(imageView, resId, imageOptions);
    }

    public void loadImage(ImageView imageView, int resId) {
        mImageLoaderStrategy.loadImage(imageView, resId);
    }

    public void loadImage(ImageView imageView, File file) {
        mImageLoaderStrategy.loadImage(imageView, file);
    }

    public void loadImage(ImageView imageView, File file, ImageOptions imageOptions) {
        mImageLoaderStrategy.loadImage(imageView, file, imageOptions);
    }

    public void loadImage(ImageView imageView, Uri uri) {
        mImageLoaderStrategy.loadImage(imageView, uri);
    }

    public void loadImage(ImageView imageView, Uri uri, ImageOptions imageOptions) {
        mImageLoaderStrategy.loadImage(imageView, uri, imageOptions);
    }

    public void setDiskCacheSize(long size){
        mImageLoaderStrategy.setDiskCacheSize(size);
    }

    /**
     * 设置图片加载使用的框架，默认为Glide
     *
     * @param imageLoaderStrategy
     */
    public void setImageLoaderStrategy(BaseImageLoaderStrategy imageLoaderStrategy) {
        this.mImageLoaderStrategy = imageLoaderStrategy;
    }
}
