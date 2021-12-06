package com.cedricakrou.artisanat.presentation.features.signIn

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.common.Result
import com.cedricakrou.artisanat.data.managers.contrats.UserManager
import com.cedricakrou.artisanat.presentation.common.BaseViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    val userManager: UserManager
) : BaseViewModel<SignInIntent, SignInAction, SignInState>() {

    override fun intentToAction(intent: SignInIntent): SignInAction {

        return when( intent ){
            is SignInIntent.SUBMIT -> SignInAction.SUBMIT( username = intent.username, password = intent.password )
        }

    }

    override fun handleAction(action: SignInAction) {

        launchOnUi {

            when( action ) {

                is SignInAction.SUBMIT -> {

                    userManager.signIn(
                        username = action.username,
                        password = action.password
                    ).collect {

                        mState.postValue(
                            when( it ) {
                                is Result.Error -> SignInState.Error( it.exception )
                                is Result.Success -> SignInState.Success( ApiResponse( error=  it.data.error, message =  it.data.message, data =  it.data.data  ) )
                                is Result.Loading -> SignInState.LOADING
                            }
                        )

                    }

                }

            }

        }

    }
}