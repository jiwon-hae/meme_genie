package com.jiwonh.rizzly.domain.usecase

import com.jiwonh.rizzly.data.repository.LlamaRepositoryImpl
import com.jiwonh.rizzly.domain.entity.PickupStyle
import com.jiwonh.rizzly.domain.entity.RizzRatingResult
import com.jiwonh.rizzly.domain.entity.Tone
import com.jiwonh.rizzly.domain.entity.Vibe
import com.llama.llamastack.client.LlamaStackClientClient
import com.llama.llamastack.client.local.LlamaStackClientLocalClient
import java.util.concurrent.Executors
import javax.inject.Inject

interface LlamaUseCase {
    fun generateDmResponse(context : String, tone : Tone) : String
    fun generateCaption(vibe : Vibe) : String
    fun rateAndRewriteText(message : String) : RizzRatingResult
    fun buildPickupLine(topic: String, style: PickupStyle): String
}

class LlamaUseCaseImpl @Inject constructor(
    private val lLamaRepository: LlamaRepositoryImpl,
    private val modelPath : String,
    private val tokenizerPath : String,
    private val temperature : Float,
    val useAgent : Boolean
) : LlamaUseCase {
    private lateinit var llamaClient: LlamaStackClientClient

    init{
        val executor = Executors.newSingleThreadExecutor()
        val future = executor.submit {
            try {
                llamaClient = LlamaStackClientLocalClient
                    .builder()
                    .modelPath(modelPath)
                    .tokenizerPath(tokenizerPath)
                    .temperature(temperature)
                    .useAgent(useAgent)
                    .build()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        future.get() // Blocks until the task is complete
        executor.shutdown()
    }

    override fun generateDmResponse(context: String, tone: Tone): String {
        TODO("Not yet implemented")
    }

    override fun generateCaption(vibe: Vibe) : String {
        TODO("Not yet implemented")
    }

    override fun rateAndRewriteText(message: String): RizzRatingResult {
        TODO("Not yet implemented")
    }

    override fun buildPickupLine(topic: String, style: PickupStyle): String {
        TODO("Not yet implemented")
    }

}