package com.qianfan.qfimage.glide

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.qianfan.qfimage.ImageOptions
import com.qianfan.qfimage.QfImage
import com.qianfan.qfimage.base.BaseImageLoaderStrategy
import java.io.File

class GlideImageLoaderStrategy : BaseImageLoaderStrategy {
    override fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView)
            .load(url)
            .into(imageView)
    }

    override fun loadImage(imageView: ImageView, url: String, options: ImageOptions) {
        val requestBuilder: RequestBuilder<Drawable> =
            GlideApp.with(imageView).load(url)
        loadWidthOption(imageView, requestBuilder, options)
    }

    override fun loadImage(imageView: ImageView, resId: Int) {
        Glide.with(imageView)
            .load(resId)
            .into(imageView)
    }

    override fun loadImage(imageView: ImageView, resId: Int, options: ImageOptions) {
        val requestBuilder: RequestBuilder<Drawable> = GlideApp.with(imageView).load(resId)
        loadWidthOption(imageView, requestBuilder, options)
    }

    override fun loadImage(imageView: ImageView, file: File) {
        Glide.with(imageView)
            .load(file)
            .into(imageView)
    }

    override fun loadImage(imageView: ImageView, file: File, options: ImageOptions) {
        val requestBuilder: RequestBuilder<Drawable> = GlideApp.with(imageView).load(file)
        loadWidthOption(imageView, requestBuilder, options)
    }

    override fun loadImage(imageView: ImageView, uri: Uri) {
        Glide.with(imageView)
            .load(uri)
            .into(imageView)
    }

    override fun loadImage(imageView: ImageView, uri: Uri, options: ImageOptions) {
        val requestBuilder: RequestBuilder<Drawable> = GlideApp.with(imageView).load(uri)
        loadWidthOption(imageView, requestBuilder, options)
    }

    override fun setDiskCacheSize(cacheSize: Long) {
        QFAppGlideModule.DISK_CACHE_SIZE = cacheSize
    }

    /**
     * 使用配置好的参数进行加载
     *
     * @param imageView
     * @param requestBuilder
     * @param options
     */
    private fun loadWidthOption(
        imageView: ImageView,
        requestBuilder: RequestBuilder<Drawable>,
        options: ImageOptions
    ) {
        applyOptions(options, requestBuilder)
        requestBuilder.into(imageView)
    }

    /**
     * 应用配置
     *
     * @param options
     * @param requestBuilder
     */
    @SuppressLint("CheckResult")
    private fun applyOptions(
        options: ImageOptions,
        requestBuilder: RequestBuilder<Drawable>
    ) {
        val placeholderId: Int = options.placeholderId
        val placeholderDrawable: Drawable? = options.placeholderDrawable
        val errorId: Int = options.errorId
        val errorDrawable: Drawable? = options.errorDrawable
        val circleCrop: Boolean = options.isCircleCrop
        val centerCrop: Boolean = options.isCenterCrop
        val roundCorner: Int = options.roundCorner
        val overrideWidth: Int = options.overrideWidth
        val overrideHeight: Int = options.overrideHeight
        val fadeDuration: Int = options.fadeDuration

        /**
         * 控制占位图和实际加载图是否交叉淡入淡出
         * 因为加载带透明像素图时，默认禁用的交叉淡入淡出会导致后面占位图任然可见
         */
        val crossFadeEnable: Boolean = options.crossFadeEnable
        if (placeholderId > 0) {
            requestBuilder.placeholder(placeholderId)
        } else if (placeholderDrawable != null) {
            requestBuilder.placeholder(placeholderDrawable)
        }
        if (errorId > 0) {
            requestBuilder.error(errorId)
        } else if (errorDrawable != null) {
            requestBuilder.error(errorDrawable)
        }
        if (circleCrop) {
            requestBuilder.circleCrop()
        }
        if (centerCrop) {
            requestBuilder.centerCrop()
        }
        if (roundCorner > 0) {
            requestBuilder.transform(RoundedCorners(roundCorner))
        }
        if (overrideWidth > 0 && overrideHeight > 0) {
            requestBuilder.override(overrideWidth, overrideHeight)
        }
        if (fadeDuration > 0) {
            if (crossFadeEnable) {
                requestBuilder.transition(DrawableTransitionOptions().crossFade(DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true)))
            }else{
                requestBuilder.transition(DrawableTransitionOptions().crossFade(fadeDuration))
            }
        }
    }

    private fun setHeaders(url: String): GlideUrl {
        var glideUrl = GlideUrl(url)
        glideUrl.headers.putAll(QfImage.headers)
        return glideUrl
    }
}