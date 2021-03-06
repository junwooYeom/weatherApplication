package com.junwooyeom.weatherapplication.presentation.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.junwooyeom.weatherapplication.presentation.GlideApp

object BindingAdapter {

    private const val IMAGE_URL = "https://www.metaweather.com/static/img/weather/png/64/%s.png"

    @BindingAdapter("imageItem")
    @JvmStatic
    fun load(imageView: ImageView, item: String) {
        GlideApp.with(imageView.context).load(
            String.format(IMAGE_URL, item)
        ).into(imageView)
    }
}
