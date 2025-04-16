package com.jiwonh.rizzly.domain.entity

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val TIMESTAMP_FORMAT = "hh:mm a"

data class LlamaMessage(
    val promptId: Int,
    val text: String,
    val isSent : Int,
    val messageType: MessageType,
    val tokensPerSecond: Float,
    val totalGenerationTime: Long
) {
    val imagePath: String
        get() = if (messageType == MessageType.IMAGE) text else ""

    private val timestamp : Long
        get() = if (messageType == MessageType.SYSTEM) System.currentTimeMillis() else 0

    private val formatedTimeStamp : String
        get() {
            val formatter = SimpleDateFormat(TIMESTAMP_FORMAT, Locale.getDefault())
            val date = Date(timestamp)
            return formatter.format(date)
        }
}
