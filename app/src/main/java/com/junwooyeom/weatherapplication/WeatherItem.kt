package com.junwooyeom.weatherapplication

data class WeatherItem(
    val cityName: String,
    val today: WeatherDto,
    val tomorrow: WeatherDto
)