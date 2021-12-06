package com.cedricakrou.artisanat.presentation.features.codeOtp

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.managers.contrats.UserManager
import com.cedricakrou.artisanat.presentation.common.BaseViewModel
import com.cedricakrou.artisanat.data.common.Result
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class CodeOtpViewModel @Inject constructor(
    val userManager: UserManager
) : BaseViewModel<
        CodeOtpIntent,
        CodeOtpAction,
        CodeOtpState>( ) {
    override fun intentToAction(intent: CodeOtpIntent): CodeOtpAction {
        return when( intent ) {
            is CodeOtpIntent.SUBMIT -> CodeOtpAction.SUBMIT( intent.username, intent.codeOtp )
        }
    }

    override fun handleAction(action: CodeOtpAction) {

        launchOnUi {

            when( action ) {

                is CodeOtpAction.SUBMIT -> {

                    userManager.validateOtpCode(
                        username = action.username,
                        code = action.codeOtp
                    ).collect {

                        mState.postValue(
                            when( it ) {
                                is Result.Error -> CodeOtpState.Error( it.exception )
                                is Result.Success -> CodeOtpState.Success( ApiResponse( error=  it.data.error, message =  it.data.message, data =  it.data.data  ) )
                                is Result.Loading -> CodeOtpState.LOADING
                            }
                        )

                    }

                }

            }

        }

    }
}