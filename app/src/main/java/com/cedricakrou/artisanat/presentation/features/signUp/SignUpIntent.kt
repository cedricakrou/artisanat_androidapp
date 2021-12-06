package com.cedricakrou.artisanat.presentation.features.signUp

import com.cedricakrou.artisanat.presentation.common.IViewIntent

sealed class SignUpIntent : IViewIntent {

    data class SUBMIT ( val firstname : String,
                        val lastname : String,
                        val phoneNumber : String,
                        val email : String,
                        val username : String,
                        val password : String,
                        val confirmPassword : String
    ) : SignUpIntent()

}