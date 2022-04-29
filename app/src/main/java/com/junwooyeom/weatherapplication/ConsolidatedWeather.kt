package com.junwooyeom.weatherapplication

import com.google.gson.annotations.SerializedName

data class ConsolidatedWeather(
    @SerializedName("id")
    val id: Int,
    @SerializedName("weather_state_name")
    val weatherStateName: String,
    @SerializedName("weather_state_abbr")
    val weatherStateAbbr: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("applicable_date")
    val applicable_date: String,
    @SerializedName("min_temp")
    val minTemperature: Float,
    @SerializedName("max_temp")
    val maxTemperature: Float,
    @SerializedName("the_temp")
    val theTemperature: Float,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("wind_direction")
    val windDirection: Double,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("visibility")
    val visibility: Double,
    @SerializedName("predictability")
    val predictability: Int
)
