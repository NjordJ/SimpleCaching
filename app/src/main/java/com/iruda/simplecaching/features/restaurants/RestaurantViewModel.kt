package com.iruda.simplecaching.features.restaurants

import androidx.lifecycle.*
import com.iruda.simplecaching.api.RestaurantApi
import com.iruda.simplecaching.data.Restaurant
import com.iruda.simplecaching.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel() {

    /*private val restaurantsLiveData = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>> = restaurantsLiveData

    init {
        viewModelScope.launch {
            val restaurants = api.getRestaurants()

            restaurantsLiveData.value = restaurants
        }
    }*/

    val restaurants = repository.getRestaurants().asLiveData()

}