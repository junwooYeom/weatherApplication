package com.junwooyeom.weatherapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    val weatherIntent = Channel<WeatherIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow<WeatherState>(WeatherState.Idle)
    val state: StateFlow<WeatherState>
        get() = _state

    val liveData: MutableLiveData<List<WeatherItem>> = MutableLiveData()

    fun handleIntent() {
        viewModelScope.launch {
            weatherIntent.consumeAsFlow().collect {
                when (it) {
                    is WeatherIntent.InitFetch -> getWeather(true)
                    is WeatherIntent.RefreshFetch -> getWeather(false)
                }
            }
        }
    }

    fun getWeather(isFirst: Boolean) {
        viewModelScope.launch {
            _state.value = if (isFirst) WeatherState.Loading else WeatherState.Refreshing
            _state.value = try {
                WeatherState.Weathers(getWeatherUseCase())
            } catch (e: Exception) {
                WeatherState.Error(e.localizedMessage)
            }
        }
    }
}
