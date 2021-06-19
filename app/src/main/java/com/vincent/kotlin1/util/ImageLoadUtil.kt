package com.vincent.kotlin1.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition

class ImageLoadUtil {

    companion object {

        public fun displayImageCenter(
            imageview: ImageView,
            url: String,
            context: Context,
            defultPic: Int
        ) {
            if (TextUtils.isEmpty(url + "")) {
                imageview.setImageResource(defultPic);
            } else {
                var options = RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .placeholder(defultPic).error(defultPic).dontAnimate();
                Glide.with(context).load(url).apply(options)
                    .into(object : SimpleTarget<Drawable>() {

                        override fun onResourceReady(
                            resource: Drawable,
                            transition: Transition<in Drawable>?
                        ) {
                            imageview.setImageDrawable(resource)
                        }
                    });
            }
        }

    }
}