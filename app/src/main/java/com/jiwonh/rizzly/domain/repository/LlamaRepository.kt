package com.jiwonh.rizzly.domain.repository

import com.jiwonh.rizzly.domain.entity.PickupStyle
import com.jiwonh.rizzly.domain.entity.RizzRatingResult
import com.jiwonh.rizzly.domain.entity.Tone
import com.jiwonh.rizzly.domain.entity.Vibe

interface LlamaRepository {
    fun generateDmResponse(context: String, tone: Tone): String
    fun generateCaption(vibe: Vibe): String
    fun rateAndRewriteText(message: String): RizzRatingResult
    fun buildPickupLine(topic: String, style: PickupStyle): String
}