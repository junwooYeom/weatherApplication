package com.junwooyeom.weatherapplication.network

import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("location_type")
    val locationType: String,
    @SerializedName("woeid")
    val id: Int,
    @SerializedName("latt_long")
    val latLng : String,
)
