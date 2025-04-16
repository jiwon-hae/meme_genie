package com.jiwonh.rizzly

import android.app.Application
import com.jiwonh.rizzly.core.AppLogger
import com.jiwonh.rizzly.domain.repository.AppLogRepository
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class RizzlyApp : Application(){

    @Inject lateinit var appLogRepository: AppLogRepository


    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        AppLogger.init(appLogRepository)

//        if (BuildConfig.DEBUG) {
//
//        }
    }
}