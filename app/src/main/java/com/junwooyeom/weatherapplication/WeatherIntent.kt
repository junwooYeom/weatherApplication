package com.junwooyeom.weatherapplication

sealed class WeatherIntent {
    object InitFetch: WeatherIntent()
    object RefreshFetch: WeatherIntent()
}
