package com.jiwonh.rizzly.data.datasource

import com.jiwonh.rizzly.data.local.LlamaQueryDto

class LLamaDatasource {
    fun query(q : String): LlamaQueryDto {
        return LlamaQueryDto(placeholder = "placeholder")
    }
}