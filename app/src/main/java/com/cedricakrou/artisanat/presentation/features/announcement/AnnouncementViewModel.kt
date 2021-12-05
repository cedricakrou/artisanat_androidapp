package com.cedricakrou.artisanat.presentation.features.announcement

import com.cedricakrou.artisanat.presentation.common.BaseViewModel
import javax.inject.Inject

class AnnouncementViewModel @Inject constructor() : BaseViewModel<AnnouncementIntent, AnnouncementAction, AnnouncementState>() {

    override fun intentToAction(intent: AnnouncementIntent): AnnouncementAction {
        TODO("Not yet implemented")
    }

    override fun handleAction(action: AnnouncementAction) {
        TODO("Not yet implemented")
    }
}