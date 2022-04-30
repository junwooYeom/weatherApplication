package com.junwooyeom.weatherapplication.network

import com.google.gson.annotations.SerializedName

data class ConsolidatedWeatherResponse(
    @SerializedName("consolidated_weather")
    val consolidatedWeather: List<WeatherDto>
)
