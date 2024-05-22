package com.prado.compose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ObserveStateViewModel : ViewModel() {

    val loadingStateFlow = MutableStateFlow(false)// IMPORTANT QUE SEJA "FLOW"

    fun seteLoadingState(loading: Boolean){
        viewModelScope.launch {
            loadingStateFlow.emit(loading)
        }
    }
}