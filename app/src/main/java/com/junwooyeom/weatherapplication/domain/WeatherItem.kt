package com.junwooyeom.weatherapplication.domain

import com.junwooyeom.weatherapplication.network.WeatherDto

data class WeatherItem(
    val cityName: String,
    val today: WeatherDto,
    val tomorrow: WeatherDto,
)
