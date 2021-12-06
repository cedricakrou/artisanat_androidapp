package com.cedricakrou.artisanat.presentation.features.announcement

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.common.CallErrors
import com.cedricakrou.artisanat.domain.entities.Announcement
import com.cedricakrou.artisanat.presentation.common.IViewState

sealed class AnnouncementState : IViewState {
    object LOADING : AnnouncementState()
    data class Error(val exception: CallErrors) : AnnouncementState()
    data class Success( val response: ApiResponse<List<Announcement>>) : AnnouncementState()
}