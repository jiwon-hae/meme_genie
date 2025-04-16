package com.jiwonh.rizzly.domain.entity

enum class LogLevel{
    DEBUG, INFO, WARN, ERROR
}

data class AppLog(
    val timestamp: Long = System.currentTimeMillis(),
    val level : LogLevel,
    val tag : String,
    val message : String
)