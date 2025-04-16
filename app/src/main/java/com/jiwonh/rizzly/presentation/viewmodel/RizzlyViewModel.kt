package com.jiwonh.rizzly.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jiwonh.rizzly.domain.entity.PickupStyle
import com.jiwonh.rizzly.domain.entity.RizzRatingResult
import com.jiwonh.rizzly.domain.entity.Tone
import com.jiwonh.rizzly.domain.entity.Vibe
import com.jiwonh.rizzly.domain.usecase.LlamaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MainUiState(
    val query : Int? = null
)

@HiltViewModel
class RizzlyViewModel @Inject constructor(
    private val llamaUseCase: LlamaUseCase
) : ViewModel(){
    private val _dmResponse = MutableStateFlow("")
    val dmResponse : StateFlow<String> = _dmResponse

    private val _caption = MutableStateFlow("")
    val caption : StateFlow<String> = _caption

    private val _rizzRating = MutableStateFlow<RizzRatingResult?>(null)
    val rizzRating: StateFlow<RizzRatingResult?> = _rizzRating

    private val _pickupLine = MutableStateFlow("")
    val pickupLine: StateFlow<String> = _pickupLine

    fun generateDmResponse(context: String, tone: Tone) {
        viewModelScope.launch {
            _dmResponse.value = "You said '$context' with a ${tone.name.lowercase()} vibe: 'Let me rizz you real quick 😏'" // placeholder
        }
    }

    fun generateCaption(vibe: Vibe) {
        viewModelScope.launch {
            _caption.value = "Feeling ${vibe.name.lowercase()} 🌈" // placeholder
        }
    }

    fun rateAndRewriteText(message: String) {
        viewModelScope.launch {
            val score = (1..10).random()
            _rizzRating.value = RizzRatingResult(
                score = score,
                feedback = if (score > 7) "Certified Rizz God 🔥" else "Might need a rewrite 🤔",
                refinedVersion = "Try saying: 'You + Me = 🔥'"
            )
        }
    }

    fun buildPickupLine(topic: String, style: PickupStyle) {
        viewModelScope.launch {
            _pickupLine.value = "Are you into $topic? Because you're totally my type – ${style.name.lowercase()} style 💘"
        }
    }

}