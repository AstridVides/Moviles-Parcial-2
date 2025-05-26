package com.ajvlsiete.adopcionmascotas.ui.viewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.ajvlsiete.adopcionmascotas.models.Product
import com.ajvlsiete.adopcionmascotas.models.ProductRepository

class ProductViewModel : ViewModel() {
    private val _products = mutableStateListOf<Product>().apply {
        addAll(ProductRepository.products)
    }
    val products: List<Product> get() = _products

    var searchQuery by mutableStateOf("")
        private set

    var selectedProduct by mutableStateOf<Product?>(null)
        private set

    val filteredProducts: List<Product>
        get() = _products.filter {
            it.name.contains(searchQuery, ignoreCase = true) ||
                    it.category.contains(searchQuery, ignoreCase = true)
        }

    fun onSearchChange(query: String) {
        searchQuery = query
    }

    fun selectProduct(product: Product) {
        selectedProduct = product
    }

    fun addToCart(product: Product) {
        _products.replaceAll {
            if (it.id == product.id) it.copy(addedToCart = true) else it
        }
    }

    val cartItems: List<Product>
        get() = _products.filter { it.addedToCart }
}
