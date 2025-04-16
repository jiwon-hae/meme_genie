package com.jiwonh.rizzly.data.repository

import com.jiwonh.rizzly.data.local.LogDao
import com.jiwonh.rizzly.data.local.toDomain
import com.jiwonh.rizzly.data.local.toEntity
import com.jiwonh.rizzly.domain.entity.AppLog
import com.jiwonh.rizzly.domain.repository.AppLogRepository
import javax.inject.Inject

class AppLogRepositoryImpl @Inject constructor(
    private val dao: LogDao
) : AppLogRepository {
    override suspend fun saveLog(log: AppLog) {
        dao.insertLog(log.toEntity())
    }

    override suspend fun getLogs(): List<AppLog> {
        return dao.getAllLogs().map { it.toDomain() }
    }

    override suspend fun clearLogs() {
        dao.clearLogs()
    }
}