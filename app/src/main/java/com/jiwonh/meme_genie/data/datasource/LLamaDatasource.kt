package com.jiwonh.meme_genie.data.datasource

import com.jiwonh.meme_genie.data.model.LlamaQueryModel

class LLamaDatasource {
    fun query(q : String): LlamaQueryModel {
        return LlamaQueryModel(placeholder = "placeholder")
    }
}