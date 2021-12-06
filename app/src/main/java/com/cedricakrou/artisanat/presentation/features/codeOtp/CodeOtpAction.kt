package com.cedricakrou.artisanat.presentation.features.codeOtp

import com.cedricakrou.artisanat.presentation.common.IViewAction

sealed class CodeOtpAction : IViewAction {

    data class SUBMIT( val username : String, val codeOtp : String ) : CodeOtpAction()

}