package com.junwooyeom.weatherapplication.presentation.state

sealed class WeatherIntent {
    object InitFetch: WeatherIntent()
    object RefreshFetch: WeatherIntent()
}
