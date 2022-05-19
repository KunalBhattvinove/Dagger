package com.example.mydagger2

import android.app.Application
import androidx.core.view.KeyEventDispatcher
import com.example.mydagger2.di.ApplicationComponent
import com.example.mydagger2.di.DaggerApplicationComponent
import com.example.mydagger2.di.DatabaseModule
import dagger.Component

class FakeApplication: Application() {

    lateinit var applicationComponent : ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .databaseModule(DatabaseModule(this)).build()
    }
}