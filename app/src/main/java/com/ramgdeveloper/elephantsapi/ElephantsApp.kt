package com.ramgdeveloper.elephantsapi

import android.app.Application
import timber.log.Timber

class ElephantsApp: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}