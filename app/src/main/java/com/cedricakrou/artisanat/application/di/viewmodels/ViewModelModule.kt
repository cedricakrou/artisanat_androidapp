package com.cedricakrou.artisanat.application.di.viewmodels

import androidx.lifecycle.ViewModel
import com.cedricakrou.artisanat.application.di.annotations.ViewModelKey
import com.cedricakrou.artisanat.presentation.features.announcement.AnnouncementViewModel
import com.cedricakrou.artisanat.presentation.features.codeOtp.CodeOtpViewModel
import com.cedricakrou.artisanat.presentation.features.onboarding.OnBoardingViewModel
import com.cedricakrou.artisanat.presentation.features.signIn.SignInViewModel
import com.cedricakrou.artisanat.presentation.features.signUp.SignUpViewModel
import com.cedricakrou.artisanat.presentation.features.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey( SplashViewModel::class )
    abstract fun bindSplashViewModel( vm : SplashViewModel) : ViewModel


    @Binds
    @IntoMap
    @ViewModelKey( OnBoardingViewModel::class )
    abstract fun bindOnBoardingViewModel( onBoardingViewModel: OnBoardingViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey( SignInViewModel::class )
    abstract fun bindSignInViewModel( vm : SignInViewModel ) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey( SignUpViewModel::class )
    abstract fun bindSignUpViewModel( vm : SignUpViewModel ) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey( CodeOtpViewModel::class )
    abstract fun bindCodeOtpViewModel( vm : CodeOtpViewModel ) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey( AnnouncementViewModel::class )
    abstract fun bindAnnouncementViewModel( announcementViewModel: AnnouncementViewModel) : ViewModel


}