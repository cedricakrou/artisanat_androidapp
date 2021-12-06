package com.cedricakrou.artisanat.presentation.features.signUp

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.managers.contrats.UserManager
import com.cedricakrou.artisanat.presentation.common.BaseViewModel
import kotlinx.coroutines.flow.collect
import com.cedricakrou.artisanat.data.common.Result
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    val userManager: UserManager
) : BaseViewModel< SignUpIntent, SignUpAction, SignUpState >() {

    override fun intentToAction(intent: SignUpIntent): SignUpAction {

        return when( intent ) {
            is SignUpIntent.SUBMIT -> {

                SignUpAction.SUBMIT(
                    intent.firstname,
                    intent.lastname,
                    intent.phoneNumber,
                    intent.email ,
                    intent.username,
                    intent.password,
                    intent.confirmPassword
                )

            }

        }

    }

    override fun handleAction(action: SignUpAction) {

        launchOnUi {

            when( action ) {

                is SignUpAction.SUBMIT -> {

                    userManager.signUp(
                        action.firstname,
                        action.lastname,
                        action.phoneNumber,
                        action.email ,
                        action.username,
                        action.password,
                        action.confirmPassword
                    ).collect {

                        mState.postValue(
                            when( it ) {
                                is Result.Error -> SignUpState.Error( it.exception )
                                is Result.Success -> SignUpState.Success( ApiResponse( error=  it.data.error, message =  it.data.message, data =  it.data.data  ) )
                                is Result.Loading -> SignUpState.LOADING
                            }
                        )

                    }


                }

            }


        }

    }

}