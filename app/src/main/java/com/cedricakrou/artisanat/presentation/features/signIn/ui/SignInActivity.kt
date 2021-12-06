package com.cedricakrou.artisanat.presentation.features.signIn.ui

import android.content.Intent
import android.widget.Toast
import com.cedricakrou.artisanat.R
import com.cedricakrou.artisanat.presentation.Utils
import com.cedricakrou.artisanat.presentation.common.BaseActivity
import com.cedricakrou.artisanat.presentation.common.getMessage
import com.cedricakrou.artisanat.presentation.features.StoreData
import com.cedricakrou.artisanat.presentation.features.home.ui.HomeActivity
import com.cedricakrou.artisanat.presentation.features.signIn.SignInAction
import com.cedricakrou.artisanat.presentation.features.signIn.SignInIntent
import com.cedricakrou.artisanat.presentation.features.signIn.SignInState
import com.cedricakrou.artisanat.presentation.features.signIn.SignInViewModel
import com.cedricakrou.artisanat.presentation.features.signUp.ui.SignUpActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.layout_loading.loading_bar

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

        tv_sign_in.setOnClickListener {

            val intent = Intent( this, SignUpActivity::class.java )

            startActivity( intent )

            finish()
        }

    }

    override fun render(state: SignInState) {
        when( state ) {
            is SignInState.LOADING -> {
                Utils.hideAndShowView( ll_body, loading_bar )
            }
            is SignInState.Error -> {
                Utils.hideAndShowView( loading_bar, ll_body )
                Toast.makeText( this, state.exception.getMessage(this), Toast.LENGTH_LONG ).show()
            }
            is SignInState.Success -> {

                Utils.hideAndShowView( loading_bar, ll_body )

                val response = state.response

                if ( response.error ) {
                    Toast.makeText( this, response.message, Toast.LENGTH_LONG ).show()
                }
                else {

                    StoreData.clientConnected = response.data!!

                    val intent = Intent( this, HomeActivity::class.java )
                    startActivity( intent )

                    finish()
                }


            }
        }
    }


}