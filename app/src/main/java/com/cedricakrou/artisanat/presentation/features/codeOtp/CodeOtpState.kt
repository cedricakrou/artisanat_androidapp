package com.cedricakrou.artisanat.presentation.features.codeOtp

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.common.CallErrors
import com.cedricakrou.artisanat.presentation.common.IViewState

sealed class CodeOtpState : IViewState {
    object LOADING : CodeOtpState()
    data class Error(val exception: CallErrors) : CodeOtpState()
    data class Success( val response: ApiResponse<Nothing>) : CodeOtpState()
}