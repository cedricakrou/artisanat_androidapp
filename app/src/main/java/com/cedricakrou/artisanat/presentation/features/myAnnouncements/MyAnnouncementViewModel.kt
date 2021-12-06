package com.cedricakrou.artisanat.presentation.features.myAnnouncements

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.common.Result
import com.cedricakrou.artisanat.data.managers.contrats.AnnouncementManager
import com.cedricakrou.artisanat.presentation.common.BaseViewModel
import kotlinx.coroutines.flow.collect
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
                title = intent.title,
                description = intent.description,
                client = intent.client,
                speciality = intent.speciality,
                price = intent.price
            )

        }
    }

    override fun handleAction(action: MyAnnoucementAction) {

        launchOnUi {

            when( action ) {

                is MyAnnoucementAction.INIT -> {

                    announcementManager.getSpecialities().collect {

                        mState.postValue(
                            when( it ) {
                                is Result.Error -> MyAnnoucementState.Error( it.exception )
                                is Result.Success -> MyAnnoucementState.SuccessLoad( ApiResponse( error=  it.data.error, message =  it.data.message, data =  it.data.data   ) )
                                is Result.Loading -> MyAnnoucementState.LOADING
                            }
                        )

                    }

                }
                is MyAnnoucementAction.SUBMIT -> {

                    announcementManager.saveAnnouncements(
                        title = action.title,
                        description = action.description,
                        client = action.client,
                        speciality = action.speciality,
                        price = action.price
                    ).collect {

                        mState.postValue(
                            when( it ) {
                                is Result.Error -> MyAnnoucementState.Error( it.exception )
                                is Result.Success -> MyAnnoucementState.Success( ApiResponse( error=  it.data.error, message =  it.data.message, data =  null ) )
                                is Result.Loading -> MyAnnoucementState.LOADING
                            }
                        )

                    }

                }
            }

        }


    }
}