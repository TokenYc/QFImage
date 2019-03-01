package com.qianfanyun.lib.glide;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qianfanyun.lib.ImageOptions;
import com.qianfanyun.lib.base.BaseImageLoaderStrategy;

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
        applyOptions(options, requestBuilder);
        requestBuilder.into(imageView);
    }

    @SuppressWarnings("CheckResult")
    private void applyOptions(ImageOptions options,
                              GlideRequest<Drawable> requestBuilder) {
        int placeholderId = options.getPlaceholderId();
        Drawable placeholderDrawable = options.getPlaceholderDrawable();
        int errorId = options.getErrorId();
        Drawable errorDrawable = options.getErrorDrawable();
        boolean circleCrop = options.isCircleCrop();

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
    }
}
