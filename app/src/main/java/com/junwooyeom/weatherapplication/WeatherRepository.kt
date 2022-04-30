package com.junwooyeom.weatherapplication

interface WeatherRepository {
    suspend fun getWeather(): List<CityResponse>

    suspend fun getWeatherCity(woeId: Int): List<WeatherDto>
}