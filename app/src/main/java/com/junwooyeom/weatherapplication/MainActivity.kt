package com.junwooyeom.weatherapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.junwooyeom.weatherapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<WeatherViewModel>()

    private val adapter by lazy {
        WeatherAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        subscribeFlow()
    }

    private fun initRecyclerView() {
        binding.rvWeather.layoutManager = LinearLayoutManager(this)
        binding.rvWeather.adapter = adapter
        binding.rvWeather.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
    }

    private fun subscribeFlow() {
        lifecycleScope.launch {
            viewModel.state.collect {
                when(it) {
                    is WeatherState.Idle -> Unit
                    is WeatherState.Loading -> Unit // progressBar 로딩
                    is WeatherState.Refreshing -> Unit // swipeRefreshLayout 바 로딩
                    is WeatherState.Weathers -> {
                        // progressBar & SwipeRefreshLayout 뷰 GONE
                        adapter.submitList(it.weather)
                    }
                    is WeatherState.Error -> {
                        // handle Error
                    }
                }
            }
        }
    }
}
