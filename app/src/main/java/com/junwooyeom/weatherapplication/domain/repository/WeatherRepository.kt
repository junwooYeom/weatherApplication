package com.junwooyeom.weatherapplication.domain.repository

import com.junwooyeom.weatherapplication.domain.model.Location
import com.junwooyeom.weatherapplication.domain.model.Weather

interface WeatherRepository {
    suspend fun getWeather(): List<Location>

    suspend fun getWeatherCity(woeId: Int): List<Weather>
}
