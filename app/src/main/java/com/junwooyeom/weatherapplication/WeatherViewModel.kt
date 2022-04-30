package com.junwooyeom.weatherapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    val liveData: MutableLiveData<List<WeatherItem>> = MutableLiveData()

    fun getWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            liveData.postValue(getWeatherUseCase())
        }
    }

}