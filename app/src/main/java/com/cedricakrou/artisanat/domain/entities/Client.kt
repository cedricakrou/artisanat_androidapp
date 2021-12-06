package com.cedricakrou.artisanat.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties( ignoreUnknown = true )
class Client() {

    var firstname : String = ""
    var lastname : String = ""
    var phoneNumber : String =""
    var username : String =""
    var email : String =""
    var password : String =""
}