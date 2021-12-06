package com.cedricakrou.artisanat.presentation.features.home.ui

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.common.CallErrors
import com.cedricakrou.artisanat.domain.entities.Announcement
import com.cedricakrou.artisanat.presentation.common.IViewState

sealed class HomeState : IViewState {

    object LOADING : HomeState()
    data class Error(val exception: CallErrors) : HomeState()
    data class Success( val response: ApiResponse<List<Announcement>>) : HomeState()

}