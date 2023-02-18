package com.codehunters.presenter.interfaces

import com.codehunters.data.*

interface IStudTourPresenter {
    companion object {
        const val FILTER_ALL = "all"
    }

    suspend fun getArticles(): List<ArticleInfo>
    suspend fun getUniversities(universityID: String = FILTER_ALL): List<UniversityInfo>
    suspend fun getDormitories(dormitoryID: String = FILTER_ALL): List<DormitoryInfo>
    suspend fun getRooms(roomID: String = FILTER_ALL): List<RoomInfo>
    suspend fun getEvents(eventID: String = FILTER_ALL): List<EventInfo>
    suspend fun getLabs(labID: String = FILTER_ALL): List<LabInfo>
    suspend fun getReviews(): List<ReviewInfo>
}