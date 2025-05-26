package com.ajvlsiete.adopcionmascotas.view

import ads_mobile_sdk.h5
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.ajvlsiete.adopcionmascotas.ui.viewModel.ProductViewModel

@Composable
fun ProductDetail(viewModel: ProductViewModel, navController: NavHostController) {
    viewModel.selectedProduct?.let { product ->
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter(product.image),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text(product.name, style = MaterialTheme.typography.titleLarge)
            Text(product.category)
            Text("$${product.price}", style = MaterialTheme.typography.bodyLarge)
            Text(product.description, modifier = Modifier.padding(vertical = 8.dp))
            Button(onClick = {
                viewModel.addToCart(product)
                navController.popBackStack()
            }) {
                Text("Agregar al carrito")
            }
        }
    }
}
