package com.cedricakrou.artisanat.presentation.features.home.ui

import com.cedricakrou.artisanat.presentation.common.IViewIntent

sealed class HomeIntent : IViewIntent {
    object INIT : HomeIntent()
}