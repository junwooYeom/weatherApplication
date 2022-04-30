package com.junwooyeom.weatherapplication.data.repository

import com.junwooyeom.weatherapplication.domain.repository.WeatherRepository
import com.junwooyeom.weatherapplication.network.CityResponse
import com.junwooyeom.weatherapplication.network.WeatherDto
import com.junwooyeom.weatherapplication.network.WeatherInfraService
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val infraService: WeatherInfraService
) : WeatherRepository {
    override suspend fun getWeather(): List<CityResponse> =
        infraService.getCities("se")


    override suspend fun getWeatherCity(woeId: Int): List<WeatherDto> =
        infraService.getCityWeather(woeId).consolidatedWeather
}
