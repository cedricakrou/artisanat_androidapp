package com.cedricakrou.artisanat.data.managers.contrats

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.common.Result
import com.cedricakrou.artisanat.domain.entities.Announcement
import com.cedricakrou.artisanat.domain.entities.Speciality
import kotlinx.coroutines.flow.Flow

interface AnnouncementManager {

    fun listAnnouncements( username : String ) : Flow<Result<ApiResponse<List<Announcement>>>>
    fun myAnnouncements( username : String ) : Flow<Result<ApiResponse<List<Announcement>>>>

    fun saveAnnouncements(
         title : String = "",
         description : String = "",
         client : String = "",
         price : Double = 0.0,
         speciality: String = ""
    ) : Flow<Result<ApiResponse<Nothing>>>

    fun getSpecialities() : Flow<Result<ApiResponse<List<Speciality>>>>

}