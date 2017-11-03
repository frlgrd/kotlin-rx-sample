package com.mobiapps.koltintest

import android.app.Application
import com.mobiapps.koltintest.core.deps.DaggerDeps
import com.mobiapps.koltintest.core.deps.Deps
import com.mobiapps.koltintest.core.deps.NetworkModule
import java.io.File

class App : Application() {

    companion object {
        lateinit var deps: Deps
    }

    override fun onCreate() {
        super.onCreate()
        deps = DaggerDeps.builder()
                .networkModule(NetworkModule(File(cacheDir, "responses")))
                .build()
    }
}