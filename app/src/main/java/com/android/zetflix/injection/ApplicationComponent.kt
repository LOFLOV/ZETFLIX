package com.android.zetflix.injection

import com.android.zetflix.MainActivity
import com.android.zetflix.injection.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}