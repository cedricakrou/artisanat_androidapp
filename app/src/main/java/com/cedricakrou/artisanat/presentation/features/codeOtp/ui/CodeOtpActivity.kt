package com.cedricakrou.artisanat.presentation.features.codeOtp.ui

import android.content.Intent
import android.view.View
import android.widget.Toast
import com.cedricakrou.artisanat.R
import com.cedricakrou.artisanat.presentation.common.BaseActivity
import com.cedricakrou.artisanat.presentation.common.getMessage
import com.cedricakrou.artisanat.presentation.features.codeOtp.CodeOtpAction
import com.cedricakrou.artisanat.presentation.features.codeOtp.CodeOtpIntent
import com.cedricakrou.artisanat.presentation.features.codeOtp.CodeOtpState
import com.cedricakrou.artisanat.presentation.features.codeOtp.CodeOtpViewModel
import com.cedricakrou.artisanat.presentation.features.signIn.ui.SignInActivity
import kotlinx.android.synthetic.main.activity_code_otp.*
import kotlinx.android.synthetic.main.activity_code_otp.btn_submit
import kotlinx.android.synthetic.main.activity_sign_up.*


class CodeOtpActivity : BaseActivity<
        CodeOtpIntent,
        CodeOtpAction,
        CodeOtpState,
        CodeOtpViewModel>( CodeOtpViewModel::class.java ) {

    var username : String = ""

    override fun getLayoutResId(): Int = R.layout.activity_code_otp

    override fun initUI() {

    }

    override fun initDATA() {
        username = intent.getStringExtra( "username" ).toString()
    }

    override fun initEVENT() {

        btn_submit.setOnClickListener {
            dispatchIntent( CodeOtpIntent.SUBMIT( username = username, codeOtp = edt_otp_code.text.toString() ) )
        }

    }

    override fun render(state: CodeOtpState) {

        when( state ) {

            is CodeOtpState.LOADING -> {

                ll_body.visibility = View.GONE
                loading_bar.visibility = View.VISIBLE

            }

            is CodeOtpState.Error -> {
                Toast.makeText( this, "Erreur " + state.exception.getMessage(this)  , Toast.LENGTH_LONG ).show()
            }

            is CodeOtpState.Success -> {

                ll_body.visibility = View.VISIBLE
                loading_bar.visibility = View.GONE

                val response = state.response

                if ( response.error ) {
                    Toast.makeText( this, response.message, Toast.LENGTH_LONG ).show()
                }
                else {
                    Toast.makeText( this, "Votre compte est activée. Veuilllez vous connecter.", Toast.LENGTH_LONG ).show()

                    val intent = Intent( this, SignInActivity::class.java )

                    startActivity( intent )

                    finish()
                }

            }

        }

    }
}