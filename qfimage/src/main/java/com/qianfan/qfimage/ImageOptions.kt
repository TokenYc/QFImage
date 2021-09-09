package com.qianfan.qfimage

import android.content.Context
import android.graphics.drawable.Drawable


/**
 * @author ArcherYc
 * @date on 2019/2/28  4:17 PM
 * @mail 247067345@qq.com
 */
class ImageOptions(
    val placeholderId: Int,
    val errorId: Int,
    val isCircleCrop: Boolean,
    val isCenterCrop: Boolean,
    val placeholderDrawable: Drawable?,
    val errorDrawable: Drawable?,
    val roundCorner: Int,
    val overrideWidth: Int,
    val overrideHeight: Int,
    val fadeDuration: Int,
    /**
     * 控制占位图与加载图是否交叉淡入淡出
     * glide默认关闭了交叉淡入淡出，但由于加载含透明像素头像时，关闭交叉淡入淡出会导致占位图不消失，故增加此开关
     */
    val crossFadeEnable: Boolean,
) {


    class Builder {
        private var placeholderId = 0
        private var errorId = 0
        private var circleCrop = false
        private var centerCrop = false
        private var placeholderDrawable: Drawable? = null
        private var errorDrawable: Drawable? = null
        private var roundCorner = 0
        private var overrideWidth = 0
        private var overrideHeight = 0
        private var fadeDuration = 300
        private var crossFadeEnable = false
        fun placeholder(resId: Int): Builder {
            placeholderId = resId
            placeholderDrawable = null
            return this
        }

        fun placeholder(placeholderDrawable: Drawable?): Builder {
            this.placeholderDrawable = placeholderDrawable
            placeholderId = 0
            return this
        }

        fun error(resId: Int): Builder {
            errorId = resId
            errorDrawable = null
            return this
        }

        fun error(drawable: Drawable?): Builder {
            errorDrawable = drawable
            errorId = 0
            return this
        }

        fun circleCrop(): Builder {
            circleCrop = true
            return this
        }

        fun centerCrop(): Builder {
            centerCrop = true
            return this
        }

        @Deprecated("Glide的corner仅对加载的图片设置圆角，对placeHolder和error无效", ReplaceWith(
            "RImageView app:corner_radius=\"4dp\"",
            "com.qianfanyun.qfui.rlayout.RImageView"
        )
        )
        fun roundCorner(corner: Int): Builder {
            roundCorner = corner
            return this
        }

        @Deprecated("Glide的corner仅对加载的图片设置圆角，对placeHolder和error无效", ReplaceWith(
            "RImageView app:corner_radius=\"4dp\"",
            "com.qianfanyun.qfui.rlayout.RImageView"
        )
        )
        fun roundCornerDp(corner: Int): Builder {
            roundCorner = dp2px(QfImage.applicationContext, corner.toFloat())
            return this
        }

        fun override(width: Int, height: Int): Builder {
            overrideWidth = width
            overrideHeight = height
            return this
        }

        fun fadeDuration(duration: Int): Builder {
            fadeDuration = duration
            return this
        }

        fun crossFadeEnable(crossFade: Boolean): Builder {
            this.crossFadeEnable = crossFade
            return this
        }

        private fun dp2px(context: Context, dpValue: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (dpValue * scale + 0.5f).toInt()
        }

        fun build(): ImageOptions {
            return ImageOptions(
                placeholderId,
                errorId,
                circleCrop,
                centerCrop,
                placeholderDrawable,
                errorDrawable,
                roundCorner,
                overrideWidth,
                overrideHeight,
                fadeDuration,
                crossFadeEnable
            )
        }
    }

    companion object {
        fun option(): Builder {
            return Builder()
        }

        fun placeholder(resId: Int): Builder {
            return Builder().placeholder(resId)
        }

        fun placeholder(placeholderDrawable: Drawable?): Builder {
            return Builder().placeholder(placeholderDrawable)
        }

        fun error(resId: Int): Builder {
            return Builder().error(resId)
        }

        fun error(drawable: Drawable?): Builder {
            return Builder().error(drawable)
        }

        fun circleCrop(): Builder {
            return Builder().circleCrop()
        }

        fun centerCrop(): Builder {
            return Builder().centerCrop()
        }

        fun roundCorner(corner: Int): Builder {
            return Builder().roundCorner(corner)
        }

        fun roundCornerDp(corner: Int): Builder {
            return Builder().roundCornerDp(corner)
        }

        fun override(width: Int, height: Int): Builder {
            return Builder().override(width, height)
        }

        fun fadeDuration(duration: Int): Builder {
            return Builder().fadeDuration(duration)
        }
        fun crossFadeEnable(crossFade: Boolean): Builder {
            return Builder().crossFadeEnable(crossFade)
        }
    }


}
