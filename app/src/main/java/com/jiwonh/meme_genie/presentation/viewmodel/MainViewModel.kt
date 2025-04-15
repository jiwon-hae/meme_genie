package com.jiwonh.meme_genie.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.jiwonh.meme_genie.domain.usecase.LlamaUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MainUiState(
    val query : Int? = null
)

class MainViewModel(
    private val llamaUseCase: LlamaUseCase,
    private val coroutineScope: CoroutineScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState : StateFlow<MainUiState> = _uiState.asStateFlow()

    override fun onCleared() {
        coroutineScope.cancel()
    }
}