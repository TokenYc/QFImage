package com.qianfan.qfimage.base

import android.net.Uri
import android.widget.ImageView
import com.qianfan.qfimage.ImageOptions
import java.io.File

interface BaseImageLoaderStrategy {
    fun loadImage(imageView: ImageView, url: String)
    fun loadImage(imageView: ImageView, url: String, options: ImageOptions)
    fun loadImage(imageView: ImageView, resId: Int)
    fun loadImage(imageView: ImageView, resId: Int, options: ImageOptions)
    fun loadImage(imageView: ImageView, file: File)
    fun loadImage(imageView: ImageView, file: File, options: ImageOptions)
    fun loadImage(imageView: ImageView, uri: Uri)
    fun loadImage(imageView: ImageView, uri: Uri, options: ImageOptions)
    fun setDiskCacheSize(cacheSize: Long)
}