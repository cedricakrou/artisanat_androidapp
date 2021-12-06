package com.cedricakrou.artisanat.presentation.features.signIn.ui

import android.content.Intent
import com.cedricakrou.artisanat.R
import com.cedricakrou.artisanat.presentation.common.BaseActivity
import com.cedricakrou.artisanat.presentation.features.signIn.SignInAction
import com.cedricakrou.artisanat.presentation.features.signIn.SignInIntent
import com.cedricakrou.artisanat.presentation.features.signIn.SignInState
import com.cedricakrou.artisanat.presentation.features.signIn.SignInViewModel
import com.cedricakrou.artisanat.presentation.features.signUp.ui.SignUpActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : BaseActivity<
        SignInIntent,
        SignInAction,
        SignInState,
        SignInViewModel
        >(  SignInViewModel::class.java ) {

    override fun getLayoutResId(): Int = R.layout.activity_sign_in

    override fun initUI() {

    }

    override fun initDATA() {

    }

    override fun initEVENT() {

        btn_submit.setOnClickListener {

            dispatchIntent(
                SignInIntent.SUBMIT(
                    username = edt_username.text.toString(),
                    password = edt_password.text.toString()
                ) )

        }

        tv_sign_up.setOnClickListener {

            val intent = Intent( this, SignUpActivity::class.java )

            startActivity( intent )

            finish()
        }

    }

    override fun render(state: SignInState) {
        when( state ) {
            is SignInState.LOADING -> {

            }
            is SignInState.Error -> {

            }
            is SignInState.Success -> {

            }
        }
    }


}