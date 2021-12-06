package com.cedricakrou.artisanat.presentation.features.home.ui

import com.cedricakrou.artisanat.presentation.common.IViewAction

sealed class HomeAction : IViewAction {
    object INIT : HomeAction()
}