package com.cedricakrou.artisanat.presentation.features.signUp

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.common.CallErrors
import com.cedricakrou.artisanat.presentation.common.IViewState

sealed class SignUpState : IViewState {
    object LOADING : SignUpState()
    data class Error(val exception: CallErrors) : SignUpState()
    data class Success( val response: ApiResponse<Nothing>) : SignUpState()
}