package com.cedricakrou.artisanat.infrastructure.remote

interface ApiService {

/**
    @FormUrlEncoded
    @POST( value = Config.SEND_CODE)
    suspend fun sendCode(@Field( value = "memberNo" ) memberNo : String ) : Response< ApiResponse<Nothing> >
**/
}