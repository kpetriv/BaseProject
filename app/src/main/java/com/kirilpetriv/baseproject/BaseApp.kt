package com.kirilpetriv.baseproject

import android.app.Application
import com.kirilpetriv.baseproject.di.baseAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BaseApp)
            modules(baseAppModule)
        }
    }
}