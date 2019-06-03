package com.mihaidornea.mvp_project

import android.app.Application
import com.mihaidornea.mvp_project.injection.AppModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MVPApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MVPApplication)
            modules(AppModules.modules)
        }
    }
}