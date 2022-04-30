package com.junwooyeom.weatherapplication

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapter {

    private const val IMAGE_URL = "https://www.metaweather.com/static/img/weather/%s.svg"

    @BindingAdapter("imageItem")
    @JvmStatic
    fun load(imageView: ImageView, item: String) {
        GlideApp.with(imageView.context).load(
            String.format(IMAGE_URL, item)
        ).into(imageView)
    }
}