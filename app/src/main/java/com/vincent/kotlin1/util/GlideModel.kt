package com.vincent.kotlin1.util

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator
import com.bumptech.glide.module.AppGlideModule

class GlideModel : AppGlideModule(){
    override fun applyOptions(context: Context?, builder: GlideBuilder?) {
        if(builder != null) {
            var calculator =
                MemorySizeCalculator.Builder(context).setMemoryCacheScreens(2F).build();
            builder.setMemoryCache(LruResourceCache(calculator.getMemoryCacheSize().toLong()));
            var diskCacheSizeBytes = 1024 * 1024 * 500; // 100 MB
            builder.setDiskCache(
                InternalCacheDiskCacheFactory(
                    context,
                    diskCacheSizeBytes.toLong()
                )
            )
        }
    }

    override fun isManifestParsingEnabled(): Boolean {
        return  false
    }
}