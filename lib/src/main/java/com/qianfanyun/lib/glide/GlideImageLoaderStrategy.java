package com.qianfanyun.lib.glide;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.qianfanyun.lib.ImageOptions;
import com.qianfanyun.lib.base.BaseImageLoaderStrategy;

import java.io.File;

/**
 * @author ArcherYc
 * @date on 2019/2/28  4:38 PM
 * @mail 247067345@qq.com
 */
public class GlideImageLoaderStrategy implements BaseImageLoaderStrategy {


    @Override
    public void loadImage(ImageView imageView, String url) {
        Glide.with(imageView)
                .load(url)
                .into(imageView);
    }

    @Override
    public void loadImage(ImageView imageView, String url, ImageOptions options) {
        GlideRequest<Drawable> requestBuilder = GlideApp.with(imageView).load(url);
        loadWidthOption(imageView, requestBuilder, options);
    }

    @Override
    public void loadImage(ImageView imageView, int resId) {
        Glide.with(imageView)
                .load(resId)
                .into(imageView);
    }

    @Override
    public void loadImage(ImageView imageView, int resId, ImageOptions options) {
        GlideRequest<Drawable> requestBuilder = GlideApp.with(imageView).load(resId);
        loadWidthOption(imageView, requestBuilder, options);
    }

    @Override
    public void loadImage(ImageView imageView, File file) {
        Glide.with(imageView)
                .load(file)
                .into(imageView);
    }

    @Override
    public void loadImage(ImageView imageView, File file, ImageOptions options) {
        GlideRequest<Drawable> requestBuilder = GlideApp.with(imageView).load(file);
        loadWidthOption(imageView, requestBuilder, options);
    }

    @Override
    public void loadImage(ImageView imageView, Uri uri) {
        Glide.with(imageView)
                .load(uri)
                .into(imageView);
    }

    @Override
    public void loadImage(ImageView imageView, Uri uri, ImageOptions options) {
        GlideRequest<Drawable> requestBuilder = GlideApp.with(imageView).load(uri);
        loadWidthOption(imageView, requestBuilder, options);
    }

    /**
     * 使用配置好的参数进行加载
     *
     * @param imageView
     * @param requestBuilder
     * @param options
     */
    private void loadWidthOption(ImageView imageView, GlideRequest<Drawable> requestBuilder, ImageOptions options) {
        applyOptions(options, requestBuilder);
        requestBuilder.into(imageView);
    }

    /**
     * 应用配置
     *
     * @param options
     * @param requestBuilder
     */
    @SuppressWarnings("CheckResult")
    private void applyOptions(ImageOptions options,
                              GlideRequest<Drawable> requestBuilder) {
        int placeholderId = options.getPlaceholderId();
        Drawable placeholderDrawable = options.getPlaceholderDrawable();
        int errorId = options.getErrorId();
        Drawable errorDrawable = options.getErrorDrawable();
        boolean circleCrop = options.isCircleCrop();
        boolean centerCrop = options.isCenterCrop();
        int roundCorner = options.getRoundCorner();
        int overrideWidth = options.getOverrideWidth();
        int overrideHeight = options.getOverrideHeight();

        if (placeholderId > 0) {
            requestBuilder.placeholder(placeholderId);
        } else if (placeholderDrawable != null) {
            requestBuilder.placeholder(placeholderDrawable);
        }

        if (errorId > 0) {
            requestBuilder.error(errorId);
        } else if (errorDrawable != null) {
            requestBuilder.error(errorDrawable);
        }

        if (circleCrop) {
            requestBuilder.circleCrop();
        }

        if (centerCrop) {
            requestBuilder.centerCrop();
        }

        if (roundCorner > 0) {
            requestBuilder.transform(new RoundedCorners(roundCorner));
        }

        if (overrideWidth > 0 && overrideHeight > 0) {
            requestBuilder.override(overrideWidth, overrideHeight);
        }

    }
}
