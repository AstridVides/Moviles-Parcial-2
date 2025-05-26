package com.ajvlsiete.adopcionmascotas.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import com.ajvlsiete.adopcionmascotas.ui.viewModel.ProductViewModel
import com.ajvlsiete.adopcionmascotas.view.ProductDetail
import com.ajvlsiete.adopcionmascotas.view.ProductList
import com.ajvlsiete.adopcionmascotas.ui.components.ProductCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val viewModel: ProductViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi Tienda") },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screen.Cart.route)
                    }) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Carrito")
                    }
                }
            )
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.List.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Screen.List.route) {
                ProductList(viewModel, navController)
            }
            composable(Screen.Detail.route) {
                ProductDetail(viewModel, navController)
            }
            composable(Screen.Cart.route) {
                ProductCard(viewModel)
            }
        }
    }
}
