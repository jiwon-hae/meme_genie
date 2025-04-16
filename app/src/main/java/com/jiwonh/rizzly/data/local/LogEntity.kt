package com.jiwonh.rizzly.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jiwonh.rizzly.domain.entity.AppLog
import com.jiwonh.rizzly.domain.entity.LogLevel

@Entity(tableName = "logs")
data class LogEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val timestamp : Long,
    val level : String,
    val tag : String,
    val message : String
)

fun AppLog.toEntity() = LogEntity(0, timestamp, level.name, tag, message)
fun LogEntity.toDomain() = AppLog(timestamp, LogLevel.valueOf(level), tag, message)
