package com.jiwonh.rizzly.data.repository

import com.jiwonh.rizzly.data.datasource.LLamaDatasource
import com.jiwonh.rizzly.data.local.LlamaQueryDto
import com.jiwonh.rizzly.domain.entity.PickupStyle
import com.jiwonh.rizzly.domain.entity.RizzRatingResult
import com.jiwonh.rizzly.domain.entity.Tone
import com.jiwonh.rizzly.domain.entity.Vibe
import com.jiwonh.rizzly.domain.repository.LlamaRepository
import javax.inject.Inject

class LlamaRepositoryImpl @Inject constructor(
    private val datasource: LLamaDatasource
) : LlamaRepository {
    // TODO(query results)
    fun test(query : String) : LlamaQueryDto{
        return datasource.query(query)
    }

    override fun generateDmResponse(context: String, tone: Tone): String {
        TODO("Not yet implemented")
    }

    override fun generateCaption(vibe: Vibe): String {
        TODO("Not yet implemented")
    }

    override fun rateAndRewriteText(message: String): RizzRatingResult {
        TODO("Not yet implemented")
    }

    override fun buildPickupLine(topic: String, style: PickupStyle): String {
        TODO("Not yet implemented")
    }
}