package com.junwooyeom.weatherapplication

import android.content.Context
import android.graphics.drawable.PictureDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.caverock.androidsvg.SVG
import java.io.InputStream

@GlideModule
class SVGModule : AppGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.register(SVG::class.java, PictureDrawable::class.java, SVGTranscoder())
            .append(InputStream::class.java, SVG::class.java, SVGDecoder())
    }

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}