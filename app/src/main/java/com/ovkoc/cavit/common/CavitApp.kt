package com.ovkoc.cavit.common

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CavitApp : Application() {


    override fun onCreate() {
        super.onCreate()


        ApplicationContext.set(applicationContext)

        startKoin {
            androidContext(this@CavitApp)
            modules(KoinModules.get(applicationContext))
        }
    }
}