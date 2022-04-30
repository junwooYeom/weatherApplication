package com.junwooyeom.weatherapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.junwooyeom.weatherapplication.databinding.ItemHeaderBinding
import com.junwooyeom.weatherapplication.domain.model.WeatherItem
import com.junwooyeom.weatherapplication.databinding.ItemWeatherBinding

class WeatherAdapter : ListAdapter<WeatherItem, RecyclerView.ViewHolder>(weatherAdapter) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(
                ItemHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> return ItemViewHolder(
                ItemWeatherBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> holder.bind(getItem(position))
        }
    }

    class ItemViewHolder(
        private val binding: ItemWeatherBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WeatherItem) {
            binding.weather = item
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_HEADER
        } else {
            TYPE_ITEM
        }
    }

    class HeaderViewHolder(binding: ItemHeaderBinding) : RecyclerView.ViewHolder(binding.root)

    private companion object {
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1

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
