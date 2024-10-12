package com.dilip.qrventory.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dilip.qrventory.presentation.home.HomeViewModel

@Composable
fun DeviceCard(navController: NavController) {

    val viewModel: HomeViewModel = hiltViewModel()
    val state = viewModel.state.collectAsState()
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(text = state.value.details)
                Spacer(modifier = Modifier.size(10.dp))
                Button(
                    onClick = viewModel::startScanning
                ) {
                    Text("Scan QR")
                }

            }
        }
    }
}