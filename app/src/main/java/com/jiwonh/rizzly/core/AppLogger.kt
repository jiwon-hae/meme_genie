package com.jiwonh.rizzly.core

import android.content.Context
import android.util.Log
import com.jiwonh.rizzly.domain.entity.AppLog
import com.jiwonh.rizzly.domain.entity.LogLevel
import com.jiwonh.rizzly.domain.repository.AppLogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

object AppLogger {
    lateinit var repository: AppLogRepository

    fun init(repo: AppLogRepository) {
        repository = repo
    }

    fun log(
        level: LogLevel,
        tag: String,
        message: String
    ) {
        val log = AppLog(level = level, tag = tag, message = message)

        // Timber log
        when (level) {
            LogLevel.DEBUG -> Timber.tag(tag).d(message)
            LogLevel.INFO -> Timber.tag(tag).i(message)
            LogLevel.WARN -> Timber.tag(tag).w(message)
            LogLevel.ERROR -> Timber.tag(tag).e(message)
        }

        // Save to local DB
        CoroutineScope(Dispatchers.IO).launch {
            repository.saveLog(log)
        }
    }
}