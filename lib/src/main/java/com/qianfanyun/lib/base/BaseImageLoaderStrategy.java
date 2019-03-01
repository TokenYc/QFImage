package com.qianfanyun.lib.base;

import android.widget.ImageView;

import com.qianfanyun.lib.ImageOptions;

/**
 * 图片加载能力的抽象接口
 *
 * @author ArcherYc
 * @date on 2019/2/28  3:46 PM
 * @mail 247067345@qq.com
 */
public interface BaseImageLoaderStrategy {

    void loadImage(ImageView imageView, String url);

    void loadImage(ImageView imageView, String url, ImageOptions options);
}
