package com.cedricakrou.artisanat.presentation.features.myAnnouncements

import com.cedricakrou.artisanat.presentation.common.IViewAction

sealed class MyAnnoucementAction : IViewAction {

    object INIT : MyAnnoucementAction()
    data class SUBMIT(
        val title : String = "",
        val description : String = "",
        val client : String = "",
        val speciality: String = "",
        val price : Double = 0.0
    ) : MyAnnoucementAction()

}