package com.junwooyeom.weatherapplication.network.model.response

import com.google.gson.annotations.SerializedName
import com.junwooyeom.weatherapplication.network.model.dto.WeatherDto

data class ConsolidatedWeatherResponse(
    @SerializedName("consolidated_weather")
    val consolidatedWeather: List<WeatherDto>
)
