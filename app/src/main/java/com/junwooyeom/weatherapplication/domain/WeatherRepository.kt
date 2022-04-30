package com.junwooyeom.weatherapplication.domain

import com.junwooyeom.weatherapplication.network.CityResponse
import com.junwooyeom.weatherapplication.network.WeatherDto

interface WeatherRepository {
    suspend fun getWeather(): List<CityResponse>

    suspend fun getWeatherCity(woeId: Int): List<WeatherDto>
}
