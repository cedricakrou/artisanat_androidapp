package com.cedricakrou.artisanat.presentation.features.splash

import android.content.SharedPreferences
import com.cedricakrou.artisanat.presentation.common.BaseViewModel
import com.cedricakrou.artisanat.presentation.features.common.SharedPrefVar
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    val sharedPreferences: SharedPreferences
) : BaseViewModel<
        SplashIntent,
        SplashAction,
        SplashState>() {


    override fun intentToAction(intent: SplashIntent): SplashAction {
        return when( intent ) {
            is SplashIntent.Init -> SplashAction.Init
        }
    }

    override fun handleAction(action: SplashAction) {

        launchOnUi {

            mState.postValue(

                when ( action) {
                    is SplashAction.Init -> {

                        val firstConnection : Boolean = sharedPreferences.getBoolean( SharedPrefVar.firstConnection, false )

                        if ( firstConnection ) SplashState.SignUp else SplashState.FirstConnection

                    }
                }

            )



        }

    }
}