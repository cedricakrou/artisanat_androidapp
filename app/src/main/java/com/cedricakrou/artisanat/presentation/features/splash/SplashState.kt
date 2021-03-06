package com.cedricakrou.artisanat.presentation.features.splash

import com.cedricakrou.artisanat.presentation.common.IViewState

sealed class SplashState : IViewState {
    object FirstConnection : SplashState()
    object SignUp : SplashState()
}