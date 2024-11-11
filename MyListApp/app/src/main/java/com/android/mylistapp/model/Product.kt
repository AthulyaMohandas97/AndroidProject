package com.android.mylistapp.model

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val category: String
)

data class ProductResponse(
    val products: List<Product>
)

