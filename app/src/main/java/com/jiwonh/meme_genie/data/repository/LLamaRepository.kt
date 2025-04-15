package com.jiwonh.meme_genie.data.repository

import com.jiwonh.meme_genie.data.datasource.LLamaDatasource
import com.jiwonh.meme_genie.data.model.LlamaQueryModel

class LLamaRepository(
    private val datasource: LLamaDatasource
) {
    // TODO(query results)
    fun test(query : String) : LlamaQueryModel{
        return datasource.query(query)
    }
}