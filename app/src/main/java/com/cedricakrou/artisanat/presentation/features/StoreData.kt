package com.cedricakrou.artisanat.presentation.features

import com.cedricakrou.artisanat.domain.entities.Client
import com.cedricakrou.artisanat.domain.entities.Speciality

object StoreData {
   var listSpecialities : List<Speciality> = mutableListOf()
   lateinit var clientConnected : Client
}