package com.junwooyeom.weatherapplication.domain.model

data class WeatherItem(
    val cityName: String,
    val today: Weather,
    val tomorrow: Weather,
)
