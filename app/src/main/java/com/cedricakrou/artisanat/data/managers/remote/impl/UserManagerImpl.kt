package com.cedricakrou.artisanat.data.managers.remote.impl

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.common.CallErrors
import com.cedricakrou.artisanat.data.common.Result
import com.cedricakrou.artisanat.data.common.applyCommonSideEffects
import com.cedricakrou.artisanat.data.managers.contrats.UserManager
import com.cedricakrou.artisanat.domain.entities.Client
import com.cedricakrou.artisanat.infrastructure.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow


class UserManagerImpl(val apiService: ApiService) : UserManager {

    override fun signIn(username: String, password: String): Flow<Result<ApiResponse<Client>>> = flow {

        apiService.login(
            username = username,
            password = password,
        ).run {

            if ( this.isSuccessful ){

                if ( this.body()==null){
                    emit( Result.Error( CallErrors.ErrorEmptyData ) )
                }
                else {
                    emit( Result.Success(
                        ApiResponse(
                            error = this.body()!!.error,
                            message = this.body()!!.message,
                            data = this.body()!!.data
                        )
                    )
                    )
                }

            }
            else {
                emit( Result.Error( CallErrors.ErrorServer ) )
            }

        }

    }.applyCommonSideEffects().catch {
        emit(Result.Error(CallErrors.ErrorException(it)))
    }

    override fun signUp(
        firstname: String,
        lastname: String,
        phoneNumber: String,
        email: String,
        username: String,
        password: String,
        confirmPassword: String
    ): Flow<Result<ApiResponse<Nothing>>> = flow {

        apiService.signUp(
            firstname = firstname,
            lastname = lastname,
            phoneNumber = phoneNumber,
            email = email,
            username = username,
            password = password,
            confirmPassword = confirmPassword
        ).run {

            if ( this.isSuccessful ){

                if ( this.body()==null){
                    emit( Result.Error( CallErrors.ErrorEmptyData ) )
                }
                else {
                    emit( Result.Success(
                        ApiResponse(
                            error = this.body()!!.error,
                            message = this.body()!!.message,
                            data = this.body()!!.data
                            )
                        )
                    )
                }

            }
            else {
                emit( Result.Error( CallErrors.ErrorServer ) )
            }

        }

    }.applyCommonSideEffects().catch {
        emit(Result.Error(CallErrors.ErrorException(it)))
    }

    override fun validateOtpCode(
        username: String,
        code: String
    ): Flow<Result<ApiResponse<Nothing>>> = flow {

        apiService.validateOtpCode(
            username, code
        ).run {

            if ( this.isSuccessful ){

                if ( this.body()==null){
                    emit( Result.Error( CallErrors.ErrorEmptyData ) )
                }
                else {
                    emit( Result.Success(
                        ApiResponse(
                            error = this.body()!!.error,
                            message = this.body()!!.message,
                            data = null
                        )
                    )
                    )
                }

            }
            else {
                emit( Result.Error( CallErrors.ErrorServer ) )
            }

        }

    }.applyCommonSideEffects().catch {
        emit(Result.Error(CallErrors.ErrorException(it)))
    }


}