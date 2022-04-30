package com.junwooyeom.weatherapplication

import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val infraService: WeatherInfraService
) : WeatherRepository {
    override suspend fun getWeather(): List<CityResponse> =
        infraService.getCities("se")


    override suspend fun getWeatherCity(woeId: Int): List<ConsolidatedWeather> =
        infraService.getCityWeather(woeId)
}