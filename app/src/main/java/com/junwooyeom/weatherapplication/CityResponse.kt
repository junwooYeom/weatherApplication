package com.junwooyeom.weatherapplication

import com.google.gson.annotations.SerializedName

data class CityResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("location_type")
    val locationType: String,
    @SerializedName("latt_long")
    val latLng : Float,
    @SerializedName("woeid")
    val id: Int,
    @SerializedName("distance")
    val meters: Int
)
