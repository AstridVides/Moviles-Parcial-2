package com.ajvlsiete.adopcionmascotas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.ajvlsiete.adopcionmascotas.ui.viewModel.ProductViewModel

@Composable
fun ProductList(viewModel: ProductViewModel, navController: NavHostController) {
    Column {
        TextField(
            value = viewModel.searchQuery,
            onValueChange = { viewModel.onSearchChange(it) },
            label = { Text("Buscar productos") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        LazyColumn {
            items(viewModel.filteredProducts) { product ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable {
                            viewModel.selectProduct(product)
                            navController.navigate("detail")
                        }
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = rememberImagePainter(product.image),
                            contentDescription = null,
                            modifier = Modifier.size(80.dp)
                        )
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(product.name, fontWeight = FontWeight.Bold)
                            Text(product.category)
                            Text("$${product.price}")
                        }
                    }
                }
            }
        }
    }
}
