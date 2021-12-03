package com.cedricakrou.artisanat.data.common

data class ApiResponse<T : Any>(var message : String = "", var error : Boolean = true, var data : T? = null )