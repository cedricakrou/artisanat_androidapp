package com.cedricakrou.artisanat.presentation.features.codeOtp

import com.cedricakrou.artisanat.presentation.common.IViewIntent

sealed class CodeOtpIntent : IViewIntent {

    data class SUBMIT( val username : String, val codeOtp : String ) : CodeOtpIntent()

}