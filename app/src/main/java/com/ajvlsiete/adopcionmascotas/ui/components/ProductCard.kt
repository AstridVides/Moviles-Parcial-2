package com.ajvlsiete.adopcionmascotas.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberImagePainter
import com.ajvlsiete.adopcionmascotas.ui.viewModel.ProductViewModel

@Composable
fun ProductCard(viewModel: ProductViewModel) {
    val cartItems = viewModel.cartItems

    if (cartItems.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("El carrito está vacío")
        }
    } else {
        LazyColumn {
            items(cartItems) { product ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = rememberImagePainter(product.image),
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .padding(8.dp)
                        )
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(product.name, fontWeight = FontWeight.Bold)
                            Text("$${product.price}")
                        }
                    }
                }
            }
        }
    }
}

