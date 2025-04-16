package com.jiwonh.rizzly.domain.repository

import com.jiwonh.rizzly.domain.entity.AppLog

interface AppLogRepository {
    suspend fun saveLog(log: AppLog)
    suspend fun getLogs(): List<AppLog>
    suspend fun clearLogs()
}