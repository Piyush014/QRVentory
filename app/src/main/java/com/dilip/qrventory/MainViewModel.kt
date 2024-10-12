package com.dilip.qrventory

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dilip.domain.repository.PreferencesRepository
import com.dilip.qrventory.navigation.Graph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    context: Context,
    preferencesRepository: PreferencesRepository,
) : ViewModel() {
    private var splashCondition by mutableStateOf(true)

    private var startDestination by mutableStateOf(Graph.MainScreenGraph)

    init {
        Log.d("MainViewModel", "ViewModel initialized")
        viewModelScope.launch {
            Graph.MainScreenGraph
            splashCondition = true
        }
    }
}
