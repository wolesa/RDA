package com.wj.demoapp821

import android.app.Application
import com.wj.data.dataModule
import com.wj.demoapp821.view.viewModule
import com.wj.domain.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RDAApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RDAApplication)
            modules(
                viewModule,
                dataModule,
                domainModule,
            )
        }
    }
}