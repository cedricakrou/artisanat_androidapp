package com.cedricakrou.artisanat.presentation.features.myAnnouncements

import com.cedricakrou.artisanat.presentation.common.IViewIntent

sealed class MyAnnoucementIntent : IViewIntent {
    object INIT : MyAnnoucementIntent()
    data class SUBMIT(
        val title : String = "",
        val description : String = "",
        val client : String = "",
        val speciality: String = "",
        val price : Double = 0.0
    ) : MyAnnoucementIntent()
}