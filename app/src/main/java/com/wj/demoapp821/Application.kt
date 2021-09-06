package com.wj.demoapp821

import android.app.Application
import com.wj.data.dataModule
import com.wj.demoapp821.view.viewModule
import com.wj.domain.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class RDAApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@RDAApplication)
            modules(
                listOf(
                    domainModule,
                    dataModule,
                    viewModule,
                )
            )
        }
    }
}