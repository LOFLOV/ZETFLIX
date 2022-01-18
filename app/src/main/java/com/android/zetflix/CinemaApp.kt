package com.android.zetflix

import android.app.Application
import com.android.zetflix.injection.DaggerApplicationComponent
import com.android.zetflix.injection.module.NetworkModule

class CinemaApp: Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent
            .builder()
            .networkModule(NetworkModule())
            .build()
    }
}