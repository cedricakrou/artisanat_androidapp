package com.cedricakrou.artisanat.infrastructure.remote

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.domain.entities.Announcement
import com.cedricakrou.artisanat.domain.entities.Client
import com.cedricakrou.artisanat.domain.entities.Speciality
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {


    @FormUrlEncoded
    @POST( value = Config.signIn)
    suspend fun login(
        @Field( value = "username" ) username : String,
        @Field( value = "password" ) password : String
    ) : Response<ApiResponse<Client>>


    @FormUrlEncoded
    @POST( value = Config.signUp)
    suspend fun signUp(
        @Field( value = "firstname" ) firstname : String,
        @Field( value = "lastname" ) lastname : String,
        @Field( value = "phoneNumber" ) phoneNumber : String,
        @Field( value = "email" ) email : String,
        @Field( value = "username" ) username : String,
        @Field( value = "password" ) password : String,
        @Field( value = "confirmPassword" ) confirmPassword : String,
    ) : Response<ApiResponse<Nothing>>

    @FormUrlEncoded
    @POST( value = Config.verifyOtp)
    suspend fun validateOtpCode(
        @Field( value = "username" ) username : String,
        @Field( value = "code" ) code : String
    ) : Response<ApiResponse<Nothing>>

    @FormUrlEncoded
    @POST( value = Config.listAnnouncements)
    suspend fun listAnnouncements(
        @Field( value = "username" ) username : String
    ) : Response<ApiResponse<List<Announcement>>>

    @FormUrlEncoded
    @POST( value = Config.myAnnouncements)
    suspend fun myAnnouncements(
        @Field( value = "username" ) username : String
    ) : Response<ApiResponse<List<Announcement>>>

    @FormUrlEncoded
    @POST( value = Config.save)
    suspend fun saveAnnouncements(
        @Field( value = "title" ) title : String,
        @Field( value = "description" ) description : String,
        @Field(value = "client") client : String,
        @Field(value = "price") price : Double,
        @Field(value = "speciality") speciality: String,
    ) : Response<ApiResponse<List<Nothing>>>


    @FormUrlEncoded
    @GET( value = Config.specialities)
    suspend fun getspecialities(
    ) : Response<ApiResponse<List<Speciality>>>


}