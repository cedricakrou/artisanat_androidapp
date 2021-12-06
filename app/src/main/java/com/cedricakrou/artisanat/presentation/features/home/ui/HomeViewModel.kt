package com.cedricakrou.artisanat.presentation.features.home.ui

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.common.Result
import com.cedricakrou.artisanat.data.managers.contrats.AnnouncementManager
import com.cedricakrou.artisanat.presentation.common.BaseViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject


class HomeViewModel @Inject constructor(
    val announcementManager: AnnouncementManager
) : BaseViewModel<
        HomeIntent,
        HomeAction,
        HomeState>()
{
    override fun intentToAction(intent: HomeIntent): HomeAction {

        return when( intent ) {
            is HomeIntent.INIT -> HomeAction.INIT
        }

    }

    override fun handleAction(action: HomeAction) {

        launchOnUi {

            when( action ) {

                is HomeAction.INIT -> {

                    announcementManager.listAnnouncements(
                        username = "kakou"
                    ).collect {

                        mState.postValue(
                            when( it ) {
                                is Result.Error -> HomeState.Error( it.exception )
                                is Result.Success -> HomeState.Success( ApiResponse( error=  it.data.error, message =  it.data.message, data =  it.data.data  ) )
                                is Result.Loading -> HomeState.LOADING
                            }
                        )

                    }

                }

            }

        }

    }
}