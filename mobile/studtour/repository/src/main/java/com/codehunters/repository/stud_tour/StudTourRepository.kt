package com.codehunters.repository.stud_tour

import com.codehunters.data.*
import com.codehunters.network.services.IStudTourService
import com.codehunters.repository.mapping.*

class StudTourRepository(
    private val studTourService: IStudTourService
): IStudTourRepository {
    override suspend fun setAuthToken(token: String) {
        studTourService.setAuthToken(token)
    }

    override suspend fun getArticles(): List<ArticleInfo> {
        return studTourService.getArticles().toArticleInfo()
    }
    override suspend fun getUniversities(universityID: String): List<UniversityInfo> {
        return studTourService.getUniversities(universityID).toUniversityInfo()
    }
    override suspend fun getDormitories(dormitoryID: String): List<DormitoryInfo> {
        return studTourService.getDormitories(dormitoryID).toDormitoryInfo()
    }
    override suspend fun getRooms(roomID: String): List<RoomInfo> {
        return studTourService.getRooms(roomID).toRoomInfo()
    }
    override suspend fun getEvents(eventID: String): List<EventInfo> {
        return studTourService.getEvents(eventID).toEventInfo()
    }
    override suspend fun getLabs(labID: String): List<LabInfo> {
        return studTourService.getLabs(labID).toLabInfo()
    }
}