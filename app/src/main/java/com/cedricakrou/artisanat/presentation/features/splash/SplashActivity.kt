package com.cedricakrou.artisanat.presentation.features.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.cedricakrou.artisanat.R
import com.cedricakrou.artisanat.presentation.features.onboarding.ui.OnboardingActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Thread.sleep

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animation = AnimationUtils.loadAnimation(this, R.anim.anim)
        img_logo.startAnimation(animation)

        Thread {

            sleep(2000)
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
            finish()

        }.start()

    }
}