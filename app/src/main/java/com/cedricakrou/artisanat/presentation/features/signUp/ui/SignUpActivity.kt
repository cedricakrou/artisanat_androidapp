package com.cedricakrou.artisanat.presentation.features.signUp.ui

import android.content.Intent
import android.view.View
import android.widget.Toast
import com.cedricakrou.artisanat.R
import com.cedricakrou.artisanat.presentation.common.BaseActivity
import com.cedricakrou.artisanat.presentation.common.getMessage
import com.cedricakrou.artisanat.presentation.features.codeOtp.ui.CodeOtpActivity
import com.cedricakrou.artisanat.presentation.features.signIn.SignInIntent
import com.cedricakrou.artisanat.presentation.features.signUp.SignUpAction
import com.cedricakrou.artisanat.presentation.features.signUp.SignUpIntent
import com.cedricakrou.artisanat.presentation.features.signUp.SignUpState
import com.cedricakrou.artisanat.presentation.features.signUp.SignUpViewModel
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseActivity<SignUpIntent,
        SignUpAction,
        SignUpState,
        SignUpViewModel>( SignUpViewModel::class.java ) {

    override fun getLayoutResId(): Int = R.layout.activity_sign_up

    override fun initUI() {

    }

    override fun initDATA() {

    }

    override fun initEVENT() {

        btn_submit.setOnClickListener {

            dispatchIntent(
                SignUpIntent.SUBMIT(
                    firstname = edt_firstname.text.toString(),
                    lastname = edt_lastname.text.toString(),
                    phoneNumber = edt_phoneNumber.text.toString(),
                    email =  edt_email.text.toString() ,
                    username = edt_username.text.toString(),
                    password = edt_password.text.toString(),
                    confirmPassword = edt_confirm_password.text.toString()
                ) )

        }


    }

    override fun render(state: SignUpState) {

        when( state ) {

            is SignUpState.LOADING -> {

                ll_body.visibility = View.GONE
                loading_bar.visibility = View.VISIBLE

            }

            is SignUpState.Error -> {
                Toast.makeText( this, "Erreur " + state.exception.getMessage(this)  , Toast.LENGTH_LONG ).show()
            }

            is SignUpState.Success -> {

                ll_body.visibility = View.VISIBLE
                loading_bar.visibility = View.GONE

                val response = state.response

                if ( response.error ) {
                    Toast.makeText( this, response.message, Toast.LENGTH_LONG ).show()
                }
                else {
                    Toast.makeText( this, "Inscription reussie", Toast.LENGTH_LONG ).show()

                    val intent = Intent( this, CodeOtpActivity::class.java )
                    intent.putExtra( "username",  edt_username.text.toString() )
                    startActivity( intent )

                    finish()
                }

            }

        }

    }
}