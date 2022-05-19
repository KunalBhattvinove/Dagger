package com.example.mydagger2.retrofit

import com.example.mydagger2.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface Fake_API {

    @GET("products")
    suspend fun getProduct() : Response<List<Product>>
}