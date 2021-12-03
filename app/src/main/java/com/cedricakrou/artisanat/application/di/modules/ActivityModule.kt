package com.cedricakrou.artisanat.application.di.modules

import android.content.Context
import com.cedricakrou.artisanat.application.di.common.AppRouter
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

/**
    @Provides
    fun providesUserManager( apiService: ApiService) : UserManager = UserManagerImpl( apiService )
**/

}
