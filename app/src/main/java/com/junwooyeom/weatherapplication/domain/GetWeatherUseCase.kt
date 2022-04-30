package com.junwooyeom.weatherapplication.domain

import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
){
    suspend operator fun invoke() : List<WeatherItem> {
        val weatherList : MutableList<WeatherItem> = mutableListOf()
        weatherRepository.getWeather().forEach { list ->
            val response = weatherRepository.getWeatherCity(list.id)
            weatherList.add(WeatherItem(list.title, response[0], response[1]))
        }
        return weatherList
    }
}
