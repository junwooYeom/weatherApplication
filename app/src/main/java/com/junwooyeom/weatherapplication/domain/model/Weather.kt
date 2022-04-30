package com.junwooyeom.weatherapplication.domain.model

data class Weather (
    val id: Long,
    val weatherStateName: String,
    val weatherStateAbbr: String,
    val created: String,
    val applicable_date: String,
    val minTemperature: Double,
    val maxTemperature: Double,
    val theTemperature: Double,
    val windSpeed: Double,
    val windDirection: Double,
    val humidity: Int,
    val visibility: Double,
    val predictability: Int
)
