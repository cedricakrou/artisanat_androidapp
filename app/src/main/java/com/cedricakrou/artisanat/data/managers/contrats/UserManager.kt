package com.cedricakrou.artisanat.data.managers.contrats

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.common.Result
import com.cedricakrou.artisanat.domain.entities.Client
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Field

interface UserManager {
    fun signIn( username : String, password : String ) : Flow<Result<ApiResponse<Client>>>

    fun signUp(
        firstname : String,
        lastname: String,
        phoneNumber : String,
        email : String,
        username: String,
        password: String,
        confirmPassword : String
    ) : Flow< Result< ApiResponse<Nothing> > >

    fun validateOtpCode(
        @Field( value = "username" ) username : String,
        @Field( value = "code" ) code : String
    ) : Flow< Result< ApiResponse<Nothing> > >
}