package com.jiwonh.rizzly.domain.entity

data class RizzRatingResult(
    val score : Int,
    val feedback : String,
    val refinedVersion : String
)