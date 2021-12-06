package com.cedricakrou.artisanat.presentation.features.splash.ui

import android.content.Intent
import android.view.animation.AnimationUtils
import com.cedricakrou.artisanat.R
import com.cedricakrou.artisanat.presentation.common.BaseActivity
import com.cedricakrou.artisanat.presentation.features.onboarding.ui.OnboardingActivity
import com.cedricakrou.artisanat.presentation.features.signIn.ui.SignInActivity
import com.cedricakrou.artisanat.presentation.features.splash.SplashAction
import com.cedricakrou.artisanat.presentation.features.splash.SplashIntent
import com.cedricakrou.artisanat.presentation.features.splash.SplashState
import com.cedricakrou.artisanat.presentation.features.splash.SplashViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Thread.sleep

class SplashActivity : BaseActivity<
        SplashIntent, SplashAction, SplashState, SplashViewModel>( SplashViewModel::class.java )
{
    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initUI() {

        val animation = AnimationUtils.loadAnimation(this, R.anim.anim)
        img_logo.startAnimation(animation)



    }

    override fun initDATA() {

        Thread {

            sleep(2000)

            dispatchIntent( SplashIntent.Init )

        }.start()

    }

    override fun initEVENT() {


    }

    override fun render(state: SplashState) {
        when( state ) {
            SplashState.FirstConnection -> {
                val intent = Intent(this, OnboardingActivity::class.java)
                startActivity(intent)
                finish()
            }
            SplashState.SignUp -> {
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

}