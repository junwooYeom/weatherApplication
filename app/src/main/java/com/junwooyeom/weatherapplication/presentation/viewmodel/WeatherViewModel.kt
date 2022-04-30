package com.junwooyeom.weatherapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junwooyeom.weatherapplication.domain.usecase.GetWeatherUseCase
import com.junwooyeom.weatherapplication.presentation.state.WeatherIntent
import com.junwooyeom.weatherapplication.presentation.state.WeatherState
import dagger.hilt.android.lifecycle.HiltViewModel
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

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            weatherIntent.consumeAsFlow().collect {
                when (it) {
                    is WeatherIntent.InitFetch -> getWeather(true)
                    is WeatherIntent.RefreshFetch -> getWeather(false)
                }
            }
        }
    }

    private fun getWeather(isFirst: Boolean) {
        viewModelScope.launch {
            if (state.value != WeatherState.Loading) {
                _state.value = if (isFirst) WeatherState.Loading else WeatherState.Refreshing
                try {
                    _state.value = WeatherState.Weathers(getWeatherUseCase())
                } catch (e: Exception) {
                    _state.value = WeatherState.Error(e.localizedMessage)
                }
            }
        }
    }
}
