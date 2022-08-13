package com.example.newsapp

import android.app.Application
import com.example.newsapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        startKoin {
            androidContext(this@MainApplication)
            modules(appModule)
        }
    }

}