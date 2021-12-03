package com.cedricakrou.artisanat.application.di.viewmodels

import androidx.lifecycle.ViewModel
import com.cedricakrou.artisanat.application.di.annotations.ViewModelKey
import com.cedricakrou.artisanat.presentation.features.splash.ui.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey( SplashViewModel::class )
    abstract fun bindHomeViewModel( splashViewModel: SplashViewModel ) : ViewModel

/**
    @Binds
    @IntoMap
    @ViewModelKey( ScannerViewModel::class )
    abstract fun bindScannerViewModel( viewModel: ScannerViewModel ) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey( SummaryViewModel::class )
    abstract fun bindSummaryViewModel( viewModel: SummaryViewModel ) : ViewModel

    @Binds
    abstract fun bindViewModelFactory( factory: DaggerViewModelFactory) : ViewModelProvider.Factory
**/

}