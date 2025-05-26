package com.ajvlsiete.adopcionmascotas.ui.navigation

sealed class Screen(val route: String) {
    object List : Screen("list")
    object Detail : Screen("detail")
    object Cart : Screen("cart")
}
