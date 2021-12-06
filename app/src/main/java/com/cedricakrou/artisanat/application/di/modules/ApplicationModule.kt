package com.cedricakrou.artisanat.application.di.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.cedricakrou.artisanat.ArtisanatApplication
import com.cedricakrou.artisanat.data.managers.contrats.AnnouncementManager
import com.cedricakrou.artisanat.data.managers.contrats.UserManager
import com.cedricakrou.artisanat.data.managers.remote.impl.AnnouncementManagerImpl
import com.cedricakrou.artisanat.data.managers.remote.impl.UserManagerImpl
import com.cedricakrou.artisanat.infrastructure.remote.ApiService
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideApplicationContext( application : ArtisanatApplication) : Context = application.applicationContext


    @Provides
    fun sharedPreferences( context: Context ) : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    fun providesSharedPreferencesEditor( sharedPreferences: SharedPreferences ) : SharedPreferences.Editor = sharedPreferences.edit()


    @Provides
    fun providesUserAccessor( apiService: ApiService) : UserManager = UserManagerImpl( apiService )

    @Provides
    fun providesAnnouncementAccessor( apiService: ApiService ) : AnnouncementManager = AnnouncementManagerImpl( apiService )

}