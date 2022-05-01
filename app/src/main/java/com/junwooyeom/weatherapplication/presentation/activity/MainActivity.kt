package com.junwooyeom.weatherapplication.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.junwooyeom.weatherapplication.R
import com.junwooyeom.weatherapplication.databinding.ActivityMainBinding
import com.junwooyeom.weatherapplication.presentation.adapter.WeatherAdapter
import com.junwooyeom.weatherapplication.presentation.state.WeatherIntent
import com.junwooyeom.weatherapplication.presentation.viewmodel.WeatherViewModel
import com.junwooyeom.weatherapplication.presentation.state.WeatherState
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
        initListeners()
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
                when (it) {
                    is WeatherState.Idle -> {
                        viewModel.weatherIntent.send(WeatherIntent.InitFetch)
                    }
                    is WeatherState.Loading -> {
                        binding.rvWeather.visibility = View.GONE
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is WeatherState.Refreshing -> {
                        binding.layoutRefresh.isRefreshing = true
                    }
                    is WeatherState.Weathers -> {
                        binding.rvWeather.visibility = View.VISIBLE
                        binding.layoutRefresh.isRefreshing = false
                        binding.progressBar.visibility = View.GONE
                        adapter.submitList(it.weather)
                    }
                    is WeatherState.Error -> {
                        binding.rvWeather.visibility = View.GONE
                        binding.progressBar.visibility = View.GONE
                        binding.layoutRefresh.isRefreshing = false
                        Toast.makeText(
                            this@MainActivity,
                            getString(R.string.state_error),
                            Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun initListeners() {
        binding.layoutRefresh.setOnRefreshListener {
            lifecycleScope.launch {
                viewModel.weatherIntent.send(WeatherIntent.RefreshFetch)
            }
        }
    }
}
