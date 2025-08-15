package com.aag.readyho

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onBookRide: () -> Unit   // <- Ye lambda RideBookingScreen ke liye
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to ReadyHo!", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        Text("This is your Home Screen for booking rides.", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(24.dp))

        // Ride Booking button
        Button(
            onClick = { onBookRide() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Book a Ride")
        }
    }
}