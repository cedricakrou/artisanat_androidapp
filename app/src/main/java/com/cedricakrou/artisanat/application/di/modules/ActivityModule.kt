package com.cedricakrou.artisanat.application.di.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.cedricakrou.artisanat.application.di.common.AppRouter
import com.cedricakrou.artisanat.data.managers.contrats.UserManager
import com.cedricakrou.artisanat.data.managers.remote.impl.UserManagerImpl
import com.cedricakrou.artisanat.infrastructure.remote.ApiService
import com.cedricakrou.artisanat.presentation.common.RootBaseActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule constructor( private val activity: RootBaseActivity) {

    @Provides
    fun providesActivityContext() : Context = activity.application

    @Provides
    fun providesActivity() : RootBaseActivity { return activity }

    @Provides
    fun providesRouterComponent() : AppRouter = AppRouter( activity )

    @Provides
    fun sharedPreferences( context: Context ) : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    fun providesSharedPreferencesEditor( sharedPreferences: SharedPreferences ) : SharedPreferences.Editor = sharedPreferences.edit()

    @Provides
    fun providesUserAccessor( apiService: ApiService) : UserManager = UserManagerImpl( apiService )

}
