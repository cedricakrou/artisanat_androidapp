package com.cedricakrou.artisanat.application.di.components

import com.cedricakrou.artisanat.application.di.modules.ApplicationModule
import com.cedricakrou.artisanat.application.di.modules.NetworkModule
import com.cedricakrou.artisanat.application.di.viewmodels.DaggerViewModelFactory
import com.cedricakrou.artisanat.application.di.viewmodels.ViewModelModule
import com.cedricakrou.artisanat.ArtisanatApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component( modules = [ApplicationModule::class, NetworkModule::class , ViewModelModule::class ] )
@Singleton
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun application(app: ArtisanatApplication): Builder
    }

    fun provideDaggerViewModelFactory(): DaggerViewModelFactory

}