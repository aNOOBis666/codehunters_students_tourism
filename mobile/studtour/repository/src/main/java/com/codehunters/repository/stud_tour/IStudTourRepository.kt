package com.codehunters.repository.stud_tour

import com.codehunters.data.*

interface IStudTourRepository {
    companion object {
        const val FILTER_ALL = "all"
    }

    suspend fun setAuthToken(token: String)

    suspend fun getArticles(): List<ArticleInfo>
    suspend fun getUniversities(universityID: String = FILTER_ALL): List<UniversityInfo>
    suspend fun getDormitories(dormitoryID: String = FILTER_ALL): List<DormitoryInfo>
    suspend fun getRooms(roomID: String = FILTER_ALL): List<RoomInfo>
    suspend fun getEvents(eventID: String = FILTER_ALL): List<EventInfo>
    suspend fun getLabs(labID: String = FILTER_ALL): List<LabInfo>
    suspend fun getReviews(): List<ReviewInfo>
}