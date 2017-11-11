package com.mobiapps.koltintest.core.di.component

import com.mobiapps.koltintest.App
import com.mobiapps.koltintest.core.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)
}