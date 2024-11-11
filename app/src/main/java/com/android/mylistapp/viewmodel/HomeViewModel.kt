package com.android.mylistapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.mylistapp.model.Product
import com.android.mylistapp.model.RetrofitClient
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _products = MutableLiveData<List<Product>>(emptyList())
    val product: LiveData<List<Product>> get() = _products

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> get() = _loading

    init {
        viewModelScope.launch {
            getProduct()
        }
    }

    private suspend fun getProduct() {
        try {
            _loading.value = true
            val response = RetrofitClient.apiService.getProducts()
            _products.value = response.products
        } catch (e: Exception) {
            _products.value = emptyList()
        } finally {
            _loading.value = false
        }
    }
}
