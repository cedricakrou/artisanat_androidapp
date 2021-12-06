package com.cedricakrou.artisanat.presentation.features.myAnnouncements

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.common.CallErrors
import com.cedricakrou.artisanat.domain.entities.Speciality
import com.cedricakrou.artisanat.presentation.common.IViewState


sealed class MyAnnoucementState : IViewState {
    object LOADING : MyAnnoucementState()
    data class Error(val exception: CallErrors) : MyAnnoucementState()
    data class SuccessLoad( val response: ApiResponse<List<Speciality>>) : MyAnnoucementState()

    data class Success( val response: ApiResponse<Nothing>) : MyAnnoucementState()
}