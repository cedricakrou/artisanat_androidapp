package com.cedricakrou.artisanat.presentation.features.home.ui

import com.cedricakrou.artisanat.presentation.common.BaseViewModel
import javax.inject.Inject


class HomeViewModel @Inject constructor() : BaseViewModel<
        HomeIntent,
        HomeAction,
        HomeState>()
{
    override fun intentToAction(intent: HomeIntent): HomeAction {
        TODO("Not yet implemented")
    }

    override fun handleAction(action: HomeAction) {
        TODO("Not yet implemented")
    }
}