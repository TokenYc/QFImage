package com.qianfanyun.lib.glide;

import android.content.Context;
import androidx.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.module.AppGlideModule;

/**
 * @author ArcherYc
 * @date on 2019/3/3  9:51 PM
 * @mail 247067345@qq.com
 */

@GlideModule
public class QFAppGlideModule extends AppGlideModule {

    public static long DISK_CACHE_SIZE = 0;

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        if (DISK_CACHE_SIZE > 0) {
            builder.setDiskCache(new InternalCacheDiskCacheFactory(context, DISK_CACHE_SIZE));
        }
    }
}
