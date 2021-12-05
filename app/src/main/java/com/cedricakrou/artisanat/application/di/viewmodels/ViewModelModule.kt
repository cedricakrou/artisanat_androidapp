package com.cedricakrou.artisanat.application.di.viewmodels

import androidx.lifecycle.ViewModel
import com.cedricakrou.artisanat.application.di.annotations.ViewModelKey
import com.cedricakrou.artisanat.presentation.features.announcement.AnnouncementViewModel
import com.cedricakrou.artisanat.presentation.features.onboarding.OnBoardingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey( OnBoardingViewModel::class )
    abstract fun bindOnBoardingViewModel( onBoardingViewModel: OnBoardingViewModel) : ViewModel


    @Binds
    @IntoMap
    @ViewModelKey( AnnouncementViewModel::class )
    abstract fun bindOnBoardingViewModel( announcementViewModel: AnnouncementViewModel) : ViewModel


}