package com.example.prakharandroidintern.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.prakharandroidintern.models.TrendingModal

class TrendingViewModel : ViewModel() {
    private val _trendingTags = MutableLiveData<List<TrendingModal>>(
        listOf<TrendingModal>(
            TrendingModal("#techmonday", 11),
            TrendingModal("#covid-19", 12),
            TrendingModal("#fifa cup", 8),
            TrendingModal("#lockdown", 7),
            TrendingModal("#foodie", 4),
            TrendingModal("#guruji", 2),
            TrendingModal("#startups", 2),
            TrendingModal("#techmonday", 11),
            TrendingModal("#covid-19", 12),
            TrendingModal("#fifa cup", 8),
            TrendingModal("#lockdown", 7),
            TrendingModal("#foodie", 4),
            TrendingModal("#guruji", 2),
            TrendingModal("#startups", 2),
        )
    )
    val trendingTags: LiveData<List<TrendingModal>> = _trendingTags
}