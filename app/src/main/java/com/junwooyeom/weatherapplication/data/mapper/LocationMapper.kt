package com.junwooyeom.weatherapplication.data.repository

import com.junwooyeom.weatherapplication.domain.model.Location
import com.junwooyeom.weatherapplication.network.LocationResponse

fun LocationResponse.toLocation(): Location =
    Location(
        title, locationType, id, latLng
    )
