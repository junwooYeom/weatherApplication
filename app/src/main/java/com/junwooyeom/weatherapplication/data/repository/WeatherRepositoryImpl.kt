package com.junwooyeom.weatherapplication.data.repository

import com.junwooyeom.weatherapplication.data.toWeather
import com.junwooyeom.weatherapplication.domain.model.Location
import com.junwooyeom.weatherapplication.domain.model.Weather
import com.junwooyeom.weatherapplication.domain.repository.WeatherRepository
import com.junwooyeom.weatherapplication.network.WeatherInfraService
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val infraService: WeatherInfraService
) : WeatherRepository {
    override suspend fun getWeather(): List<Location> =
        infraService.getCities("se").map { it.toLocation() }


    override suspend fun getWeatherCity(woeId: Int): List<Weather> =
        infraService.getCityWeather(woeId).consolidatedWeather.map { it.toWeather() }
}
