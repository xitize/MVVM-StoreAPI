package com.telect.rrmvvm.network

import com.telect.rrmvvm.model.ResponseItem
import retrofit2.http.GET


interface RetrofitService {
    //  https://fakestoreapi.com/products
    @GET("products")
    suspend fun getProducts(): List<ResponseItem>
}

