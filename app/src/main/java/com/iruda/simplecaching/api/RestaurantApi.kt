package com.iruda.simplecaching.api

import com.iruda.simplecaching.data.Restaurant
import retrofit2.http.GET

interface RestaurantApi {

    @GET("restaurant/random_restaurant?size=50")
    suspend fun getRestaurants(): List<Restaurant>

    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }
}