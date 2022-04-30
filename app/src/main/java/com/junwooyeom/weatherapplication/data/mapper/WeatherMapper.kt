package com.junwooyeom.weatherapplication.data

import com.junwooyeom.weatherapplication.domain.model.Weather
import com.junwooyeom.weatherapplication.network.WeatherDto

fun WeatherDto.toWeather(): Weather =
    Weather(
        id,
        weatherStateName,
        weatherStateAbbr,
        created,
        applicable_date,
        minTemperature,
        maxTemperature,
        theTemperature,
        windSpeed,
        windDirection,
        humidity,
        visibility,
        predictability
    )
