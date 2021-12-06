package com.cedricakrou.artisanat.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties( ignoreUnknown = true )
class Speciality( var name : String = "") {
}