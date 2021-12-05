package com.cedricakrou.artisanat.presentation.features.signIn.ui

import com.cedricakrou.artisanat.R
import com.cedricakrou.artisanat.presentation.common.BaseActivity
import com.cedricakrou.artisanat.presentation.features.signIn.SignInAction
import com.cedricakrou.artisanat.presentation.features.signIn.SignInIntent
import com.cedricakrou.artisanat.presentation.features.signIn.SignInState
import com.cedricakrou.artisanat.presentation.features.signIn.SignInViewModel

class SignInActivity : BaseActivity<
        SignInIntent,
        SignInAction,
        SignInState,
        SignInViewModel
        >(  SignInViewModel::class.java ) {

    override fun getLayoutResId(): Int = R.layout.activity_sign_in

    override fun initUI() {
        TODO("Not yet implemented")
    }

    override fun initDATA() {
        TODO("Not yet implemented")
    }

    override fun initEVENT() {
        TODO("Not yet implemented")
    }

    override fun render(state: SignInState) {
        TODO("Not yet implemented")
    }


}