package com.testtask.myapplication

import android.app.Application
import com.testtask.myapplication.di.Di
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules (
                listOf(
                    Di.retrofitModule(),
                    Di.sourceModule(),
                    Di.mappersModule(),
                    Di.repositoryModules(),
                    Di.viewModelsModules()
                )
            )
        }
    }
}