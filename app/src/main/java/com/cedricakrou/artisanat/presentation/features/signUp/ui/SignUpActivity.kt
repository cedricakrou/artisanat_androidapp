package com.cedricakrou.artisanat.presentation.features.signUp.ui

import com.cedricakrou.artisanat.R
import com.cedricakrou.artisanat.presentation.common.BaseActivity
import com.cedricakrou.artisanat.presentation.features.signUp.SignUpAction
import com.cedricakrou.artisanat.presentation.features.signUp.SignUpIntent
import com.cedricakrou.artisanat.presentation.features.signUp.SignUpState
import com.cedricakrou.artisanat.presentation.features.signUp.SignUpViewModel

class SignUpActivity : BaseActivity<SignUpIntent,
        SignUpAction,
        SignUpState,
        SignUpViewModel>( SignUpViewModel::class.java ) {

    override fun getLayoutResId(): Int = R.layout.activity_sign_up

    override fun initUI() {
        TODO("Not yet implemented")
    }

    override fun initDATA() {
        TODO("Not yet implemented")
    }

    override fun initEVENT() {
        TODO("Not yet implemented")
    }

    override fun render(state: SignUpState) {
        TODO("Not yet implemented")
    }
}