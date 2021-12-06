package com.cedricakrou.artisanat.presentation.features.announcement

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.common.Result
import com.cedricakrou.artisanat.data.managers.contrats.AnnouncementManager
import com.cedricakrou.artisanat.presentation.common.BaseViewModel
import com.cedricakrou.artisanat.presentation.features.StoreData
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class AnnouncementViewModel @Inject constructor(
    val announcementManager: AnnouncementManager
) : BaseViewModel<AnnouncementIntent, AnnouncementAction, AnnouncementState>() {


    override fun intentToAction(intent: AnnouncementIntent): AnnouncementAction {

        return when( intent ) {
            is AnnouncementIntent.INIT -> AnnouncementAction.INIT
        }

    }

    override fun handleAction(action: AnnouncementAction) {

        launchOnUi {

            when( action ) {

                is AnnouncementAction.INIT -> {

                    announcementManager.myAnnouncements(
                        username = StoreData.clientConnected.username
                    ).collect {

                        mState.postValue(
                            when( it ) {
                                is Result.Error -> AnnouncementState.Error( it.exception )
                                is Result.Success -> AnnouncementState.Success( ApiResponse( error=  it.data.error, message =  it.data.message, data =  it.data.data  ) )
                                is Result.Loading -> AnnouncementState.LOADING
                            }
                        )

                    }

                }

            }

        }

    }

}