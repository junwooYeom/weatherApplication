package com.junwooyeom.weatherapplication.data

import com.junwooyeom.weatherapplication.data.repository.WeatherRepositoryImpl
import com.junwooyeom.weatherapplication.network.infraservice.WeatherInfraService
import com.junwooyeom.weatherapplication.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesWeatherRepository(infraService: WeatherInfraService): WeatherRepository =
        WeatherRepositoryImpl(infraService)
}
