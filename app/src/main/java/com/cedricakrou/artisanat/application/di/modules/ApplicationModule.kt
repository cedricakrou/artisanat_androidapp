package com.cedricakrou.artisanat.application.di.modules

import android.content.Context
import com.cedricakrou.artisanat.ArtisanatApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideApplicationContext( application : ArtisanatApplication) : Context = application.applicationContext

/**
    @Provides
    fun providesUserAccessor( apiService: ApiService) : UserManager = UserManagerImpl( apiService )
**/

}