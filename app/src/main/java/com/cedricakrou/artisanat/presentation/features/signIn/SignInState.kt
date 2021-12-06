package com.cedricakrou.artisanat.presentation.features.signIn

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.common.CallErrors
import com.cedricakrou.artisanat.presentation.common.IViewState

sealed class SignInState : IViewState {
    object LOADING : SignInState()
    data class Error(val exception: CallErrors) : SignInState()
    data class Success( val response: ApiResponse<Nothing>) : SignInState()
}