package com.android.mylistapp.model

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/products")
    suspend fun getProducts(): ProductResponse

    @GET("product/{id}")
    fun getProductById(@Path("id") id: Int): Product
}