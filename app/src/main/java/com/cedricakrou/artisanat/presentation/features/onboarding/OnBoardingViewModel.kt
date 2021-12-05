package com.cedricakrou.artisanat.presentation.features.onboarding

import com.cedricakrou.artisanat.presentation.common.BaseViewModel
import javax.inject.Inject

class OnBoardingViewModel @Inject constructor() : BaseViewModel<OnboardingIntent, OnboardingAction, OnboardingState>() {

    override fun intentToAction(intent: OnboardingIntent): OnboardingAction {
       return when( intent ) {
           is OnboardingIntent.Init -> OnboardingAction.InitData
       }
    }

    override fun handleAction(action: OnboardingAction) {
        launchOnUi {
            when( action) {
                is OnboardingAction.InitData -> OnboardingState.InitData
            }
        }
    }
}