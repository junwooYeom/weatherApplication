package com.junwooyeom.weatherapplication

data class WeatherItem(
    val cityName: String,
    val today: ConsolidatedWeather,
    val tomorrow: ConsolidatedWeather
)