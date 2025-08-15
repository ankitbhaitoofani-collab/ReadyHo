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
    
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginSuccess = { 
                    // TODO: Navigate to Home screen in future
                },
                onNavigateToRegister = { navController.navigate("register") }
            )
        }
        composable("register") {
            RegistrationScreen(
                onRegisterSuccess = { 
                    // TODO: Navigate to Home screen in future
                },
                onNavigateToLogin = { navController.navigate("login") }
            )
        }
    }
}