package com.junwooyeom.weatherapplication.network

import com.junwooyeom.weatherapplication.network.CityResponse
import com.junwooyeom.weatherapplication.network.ConsolidatedWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherInfraService {

    @GET("location/search/")
    suspend fun getCities(
        @Query("query") query: String
    ): List<CityResponse>

    @GET("location/{woeid}/")
    suspend fun getCityWeather(
        @Path("woeid") woeid: Int
    ) : ConsolidatedWeatherResponse

}
