package com.junwooyeom.weatherapplication.network.infraservice

import com.junwooyeom.weatherapplication.network.model.response.ConsolidatedWeatherResponse
import com.junwooyeom.weatherapplication.network.model.response.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherInfraService {

    @GET("location/search/")
    suspend fun getCities(
        @Query("query") query: String
    ): List<LocationResponse>

    @GET("location/{woeid}/")
    suspend fun getCityWeather(
        @Path("woeid") woeid: Int
    ) : ConsolidatedWeatherResponse

}
