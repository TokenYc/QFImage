package com.qianfan.qfimage.glide

import android.content.Context
import android.graphics.ImageFormat.RGB_565
import androidx.annotation.Nullable
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.model.*
import com.bumptech.glide.module.AppGlideModule
import java.io.InputStream

import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader
import com.bumptech.glide.request.RequestOptions
import com.qianfan.qfimage.QfImage


@GlideModule
class QFAppGlideModule : AppGlideModule() {
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        if (DISK_CACHE_SIZE > 0) {
            builder.setDiskCache(InternalCacheDiskCacheFactory(context, DISK_CACHE_SIZE))
        }
//        builder.setDefaultRequestOptions(
//            RequestOptions()
//                .format(DecodeFormat.PREFER_RGB_565)
//                .disallowHardwareConfig()
//        )
    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)
        registry.prepend(String::class.java, InputStream::class.java, QfImageLoader.Factory())
    }

    companion object {
        var DISK_CACHE_SIZE: Long = 0
    }


    /**
     * 自定义千帆图片加载
     * 主要用于全局设置请求Header
     */
    class QfImageLoader(urlLoader: ModelLoader<GlideUrl?, InputStream?>?) :
        BaseGlideUrlLoader<String>(urlLoader) {
        class Factory : ModelLoaderFactory<String, InputStream> {
            override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<String, InputStream> {
                return QfImageLoader(
                    multiFactory.build(
                        GlideUrl::class.java,
                        InputStream::class.java
                    )
                )
            }

            override fun teardown() {}
        }

        override fun handles(model: String): Boolean {
            return true
        }

        override fun getUrl(model: String, width: Int, height: Int, options: Options): String {
            return model
        }

        @Nullable
        override fun getHeaders(s: String, width: Int, height: Int, options: Options): Headers? {
            val headersBuilder: LazyHeaders.Builder = LazyHeaders.Builder()
            QfImage.headers.entries.forEach {
                headersBuilder.addHeader(it.key, it.value)
            }
            return headersBuilder.build()
        }
    }

}