package com.junwooyeom.weatherapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.junwooyeom.weatherapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

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
        observeLiveData()
    }

    private fun initRecyclerView() {
        binding.rvWeather.layoutManager = LinearLayoutManager(this)
        binding.rvWeather.adapter = adapter
        binding.rvWeather.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
    }

    private fun observeLiveData() {
        viewModel.liveData.observe(this) {
            adapter.submitList(it)
        }
        viewModel.getWeather()
    }
}