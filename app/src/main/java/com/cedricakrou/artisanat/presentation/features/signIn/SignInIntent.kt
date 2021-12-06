package com.cedricakrou.artisanat.presentation.features.signIn

import com.cedricakrou.artisanat.presentation.common.IViewIntent

sealed class SignInIntent : IViewIntent {
    data class SUBMIT ( val username : String, val password : String ) : SignInIntent()
}