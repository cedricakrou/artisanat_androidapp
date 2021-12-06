package com.cedricakrou.artisanat.presentation.features.myAnnouncements

import com.cedricakrou.artisanat.data.managers.contrats.AnnouncementManager
import com.cedricakrou.artisanat.presentation.common.BaseViewModel
import javax.inject.Inject

class MyAnnouncementViewModel @Inject constructor(
    val announcementManager: AnnouncementManager
) : BaseViewModel<
        MyAnnoucementIntent,
        MyAnnoucementAction,
        MyAnnoucementState> ()  {

    override fun intentToAction(intent: MyAnnoucementIntent): MyAnnoucementAction {
        return  when( intent ) {
            is MyAnnoucementIntent.INIT -> MyAnnoucementAction.INIT
            is  MyAnnoucementIntent.SUBMIT -> MyAnnoucementAction.SUBMIT(
                intent.title,
                intent.description,
                intent.client,
                intent.speciality
            )

        }
    }

    override fun handleAction(action: MyAnnoucementAction) {

        when( action ) {

            is MyAnnoucementAction.INIT -> {

            }
            is MyAnnoucementAction.SUBMIT -> {



            }
        }

    }
}