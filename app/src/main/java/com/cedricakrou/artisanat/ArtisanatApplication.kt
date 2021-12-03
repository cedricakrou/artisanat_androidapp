package com.cedricakrou.artisanat

import android.app.Application
import com.cedricakrou.artisanat.application.di.components.ApplicationComponent
import com.cedricakrou.artisanat.application.di.components.DaggerApplicationComponent

class ArtisanatApplication : Application() {

    companion object {
        lateinit var appComponents : ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponents = initDI()
    }


    private fun initDI() : ApplicationComponent =  DaggerApplicationComponent.builder().application( this ).build()

}