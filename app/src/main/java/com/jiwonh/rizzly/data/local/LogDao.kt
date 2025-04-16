package com.jiwonh.rizzly.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LogDao {
    @Insert
    suspend fun insertLog(log: LogEntity)

    @Query("SELECT * FROM logs ORDER BY timestamp DESC")
    suspend fun getAllLogs(): List<LogEntity>

    @Query("DELETE FROM logs")
    suspend fun clearLogs()
}