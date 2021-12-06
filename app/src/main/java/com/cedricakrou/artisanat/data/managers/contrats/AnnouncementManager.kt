package com.cedricakrou.artisanat.data.managers.contrats

import com.cedricakrou.artisanat.data.common.ApiResponse
import com.cedricakrou.artisanat.data.common.Result
import com.cedricakrou.artisanat.domain.entities.Announcement
import kotlinx.coroutines.flow.Flow

interface AnnouncementManager {

    fun listAnnouncements( username : String ) : Flow<Result<ApiResponse<List<Announcement>>>>

}