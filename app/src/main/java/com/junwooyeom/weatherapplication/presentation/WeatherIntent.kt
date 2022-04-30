package com.junwooyeom.weatherapplication.presentation

sealed class WeatherIntent {
    object InitFetch: WeatherIntent()
    object RefreshFetch: WeatherIntent()
}
