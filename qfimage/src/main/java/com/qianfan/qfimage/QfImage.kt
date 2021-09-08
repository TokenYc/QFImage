package com.qianfan.qfimage

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.load.model.Headers
import com.bumptech.glide.load.model.LazyHeaders
import com.qianfan.qfimage.base.BaseImageLoaderStrategy
import com.qianfan.qfimage.glide.GlideImageLoaderStrategy
import java.io.File

object QfImage {

    private var mImageLoaderStrategy: BaseImageLoaderStrategy = GlideImageLoaderStrategy()

    internal lateinit var applicationContext: Context

    internal var headers: Map<String, String> = HashMap()

    /**
     * 在application中调用
     */
    fun init(context: Context) {
        applicationContext = context
    }

    /**
     * 设置图片请求header
     */
    fun setHeaders(headers: Map<String, String>) {
        this.headers = headers
    }


    fun loadImage(imageView: ImageView, url: String, imageOptions: ImageOptions) {
        mImageLoaderStrategy.loadImage(imageView, url, imageOptions)
    }

    fun loadImage(imageView: ImageView, url: String) {
        mImageLoaderStrategy.loadImage(imageView, url)
    }

    fun loadImage(imageView: ImageView, resId: Int, imageOptions: ImageOptions) {
        mImageLoaderStrategy.loadImage(imageView, resId, imageOptions)
    }

    fun loadImage(imageView: ImageView, resId: Int) {
        mImageLoaderStrategy.loadImage(imageView, resId)
    }

    fun loadImage(imageView: ImageView, file: File) {
        mImageLoaderStrategy.loadImage(imageView, file)
    }

    fun loadImage(imageView: ImageView, file: File, imageOptions: ImageOptions) {
        mImageLoaderStrategy.loadImage(imageView, file, imageOptions)
    }

    fun loadImage(imageView: ImageView, uri: Uri) {
        mImageLoaderStrategy.loadImage(imageView, uri)
    }

    fun loadImage(imageView: ImageView, uri: Uri, imageOptions: ImageOptions) {
        mImageLoaderStrategy.loadImage(imageView, uri, imageOptions)
    }

    fun setDiskCacheSize(size: Long) {
        mImageLoaderStrategy.setDiskCacheSize(size)
    }

    /**
     * 设置图片加载使用的框架，默认为Glide
     *
     * @param imageLoaderStrategy
     */
    fun setImageLoaderStrategy(imageLoaderStrategy: BaseImageLoaderStrategy) {
        mImageLoaderStrategy = imageLoaderStrategy
    }


}