package com.android.mylistapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.android.mylistapp.viewmodel.HomeViewModel

@Composable
fun HomePage(modifier: Modifier = Modifier, viewModel: HomeViewModel = viewModel(), navController: NavController) {
    val products = viewModel.product.observeAsState().value
    val isLoading = viewModel.loading.observeAsState(true).value

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            if (products.isNullOrEmpty()) {
                Text("No Products Available..")
            } else {
                LazyColumn(modifier = modifier) {
                    items(products) { product ->
                        ProductItem(
                            product = product,
                            onClick = {
                                navController.navigate("productDetail/${product.id}")
                            }
                        )
                    }
                }
            }
        }
    }
}
