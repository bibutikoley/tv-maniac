package com.thomaskioko.tvmaniac

import android.app.Application
import com.thomaskioko.tvmaniac.inject.ApplicationComponent
import com.thomaskioko.tvmaniac.inject.create
import com.thomaskioko.tvmaniac.util.extensions.unsafeLazy

class TvManicApplication : Application() {

    private val component: ApplicationComponent by unsafeLazy { ApplicationComponent.create(this) }

    override fun onCreate() {
        super.onCreate()
        component.initializers.init()
    }
}
