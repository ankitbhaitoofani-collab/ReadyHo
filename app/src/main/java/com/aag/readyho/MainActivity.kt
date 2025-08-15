package com.aag.readyho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = { navController.navigate("home") },
                onNavigateToRegister = { navController.navigate("register") }
            )
        }

        composable("register") {
            RegistrationScreen(
                onRegisterSuccess = { navController.navigate("home") },
                onNavigateToLogin = { navController.navigate("login") }
            )
        }

        composable("home") {
            HomeScreen(
                onBookRide = { navController.navigate("rideBooking") }
            )
        }

        composable("rideBooking") {
            RideBookingScreen(
                onConfirmRide = { pickup, drop ->
                    Backend.addRide(pickup, drop)
                    navController.navigate("rideConfirm/$pickup/$drop")
                }
            )
        }

        composable(
            "rideConfirm/{pickup}/{drop}",
            arguments = listOf(
                navArgument("pickup") { type = NavType.StringType },
                navArgument("drop") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val pickup = backStackEntry.arguments?.getString("pickup") ?: ""
            val drop = backStackEntry.arguments?.getString("drop") ?: ""

            RideConfirmationScreen(
                pickup = pickup,
                drop = drop,
                onConfirm = {
                    // Future backend logic / success message
                }
            )
        }
    }
}