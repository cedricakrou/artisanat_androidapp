package com.cedricakrou.artisanat.application.di.components

import com.cedricakrou.artisanat.presentation.common.RootBaseActivity
import com.cedricakrou.artisanat.application.di.modules.ActivityModule
import com.cedricakrou.artisanat.application.di.annotations.ActivityScope
import com.cedricakrou.artisanat.application.di.common.AppRouter
import dagger.Component

@ActivityScope
@Component( modules = [ActivityModule::class], dependencies = [ApplicationComponent::class] )
interface ActivityComponent {
    fun inject( baseActivity: RootBaseActivity)
    fun appRouter() : AppRouter
}