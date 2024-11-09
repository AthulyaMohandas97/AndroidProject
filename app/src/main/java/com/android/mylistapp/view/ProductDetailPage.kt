package com.android.mylistapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.mylistapp.viewmodel.HomeViewModel

@Composable
fun ProductDetailPage(productId: Int) {

    val viewModel: HomeViewModel = viewModel()

    val products = viewModel.product.observeAsState().value

    val product = products?.find { it.id == productId }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        if (product == null) {
            CircularProgressIndicator()
        } else {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(text = "ID: ${product.id}")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Title: ${product.title}")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Description: ${product.description}")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Category: ${product.category}")
            }
        }
    }
}
