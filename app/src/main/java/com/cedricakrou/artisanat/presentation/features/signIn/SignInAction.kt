package com.cedricakrou.artisanat.presentation.features.signIn

import com.cedricakrou.artisanat.presentation.common.IViewAction

sealed class SignInAction : IViewAction{
    data class SUBMIT ( val username : String, val password : String ) : SignInAction()
}