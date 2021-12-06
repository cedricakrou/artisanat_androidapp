package com.cedricakrou.artisanat.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties( ignoreUnknown = true )
class Announcement() {

    var title: String = ""

    var description: String = ""

    var date: String = ""

    var price: Double = 0.0

    var client: Client? = null

    var speciality: Speciality? = null

    var reference : String = ""
}