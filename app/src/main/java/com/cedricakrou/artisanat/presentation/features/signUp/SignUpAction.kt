package com.cedricakrou.artisanat.presentation.features.signUp

import com.cedricakrou.artisanat.presentation.common.IViewAction

sealed class SignUpAction : IViewAction {

    data class SUBMIT ( val firstname : String,
                        val lastname : String,
                        val phoneNumber : String,
                        val email : String,
                        val username : String,
                        val password : String,
                        val confirmPassword : String
                        ) : SignUpAction()

}