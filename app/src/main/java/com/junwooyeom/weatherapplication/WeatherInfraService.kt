package com.junwooyeom.weatherapplication

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherInfraService {

    @GET("location/search/")
    suspend fun getCities(
        @Query("query") query: String
    )

    @GET("location/{woeid}/")
    suspend fun getCityWeather(
        @Path("woeid") woeid: Int
    )

}
