package com.junwooyeom.weatherapplication.presentation

import com.junwooyeom.weatherapplication.domain.model.WeatherItem

sealed class WeatherState {
    object Idle: WeatherState()
    object Loading: WeatherState()
    object Refreshing: WeatherState()
    data class Weathers(val weather: List<WeatherItem>): WeatherState()
    data class Error(val error: String?) : WeatherState()
}
