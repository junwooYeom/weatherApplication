package com.junwooyeom.weatherapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.junwooyeom.weatherapplication.databinding.ItemWeatherBinding

class WeatherAdapter : ListAdapter<WeatherItem, WeatherAdapter.ViewHolder>(weatherAdapter){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemWeatherBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WeatherItem) {
            binding.weatherItem = item
        }
    }

    private companion object {
        val weatherAdapter = object : DiffUtil.ItemCallback<WeatherItem>() {
            override fun areItemsTheSame(oldItem: WeatherItem, newItem: WeatherItem): Boolean {
                return oldItem.cityName == newItem.cityName
            }

            override fun areContentsTheSame(oldItem: WeatherItem, newItem: WeatherItem): Boolean {
                return oldItem.today == newItem.today && oldItem.tomorrow == newItem.tomorrow
            }

        }
    }
}