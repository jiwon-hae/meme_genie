package com.jiwonh.meme_genie.domain.usecase

import com.jiwonh.meme_genie.data.repository.LLamaRepository

interface LlamaUseCase {
    fun query()
}

class LlamaUseCaseImpl (
    private val lLamaRepository: LLamaRepository
) : LlamaUseCase {
    override fun query() {
        TODO("Not yet implemented")
    }

}