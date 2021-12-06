package com.cedricakrou.artisanat.data.managers.remote.impl

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.common.CallErrors
import com.cedricakrou.artisanat.data.common.Result
import com.cedricakrou.artisanat.data.common.applyCommonSideEffects
import com.cedricakrou.artisanat.data.managers.contrats.AnnouncementManager
import com.cedricakrou.artisanat.domain.entities.Announcement
import com.cedricakrou.artisanat.infrastructure.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class AnnouncementManagerImpl( val apiService: ApiService ) : AnnouncementManager {

    override fun listAnnouncements(username: String): Flow<Result<ApiResponse<List<Announcement>>>> = flow {

            apiService.listAnnouncements(
                username
            ).run {

                if ( this.isSuccessful ){

                    if ( this.body()==null){
                        emit( Result.Error( CallErrors.ErrorEmptyData ) )
                    }
                    else {
                        emit( Result.Success(
                            ApiResponse(
                                error = this.body()!!.error,
                                message = this.body()!!.message,
                                data = this.body()!!.data
                            )
                        )
                        )
                    }

                }
                else {
                    emit( Result.Error( CallErrors.ErrorServer ) )
                }

            }

        }.applyCommonSideEffects().catch {
            emit(Result.Error(CallErrors.ErrorException(it)))
        }

}