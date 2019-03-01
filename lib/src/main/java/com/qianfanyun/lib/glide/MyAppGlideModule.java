package com.qianfanyun.lib.glide;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * @author ArcherYc
 * @date on 2019/2/26  5:05 PM
 * @mail 247067345@qq.com
 */

@GlideModule
public class MyAppGlideModule extends AppGlideModule {

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        //进行各种配置
        //如缓存大小，图片解码格式等
    }
}
