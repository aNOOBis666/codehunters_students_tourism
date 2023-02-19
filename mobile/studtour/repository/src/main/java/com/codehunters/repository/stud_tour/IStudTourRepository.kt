package com.codehunters.repository.stud_tour

import com.codehunters.data.*

interface IStudTourRepository {

    suspend fun setAuthToken(token: String)

    suspend fun getArticles(): List<ArticleInfo>
    suspend fun getUniversities(universityID: String = String()): List<UniversityInfo>
    suspend fun getDormitories(dormitoryID: String = String()): List<DormitoryInfo>
    suspend fun getRooms(roomID: String = String()): List<RoomInfo>
    suspend fun getEvents(eventID: String = String()): List<EventInfo>
    suspend fun getLabs(labID: String = String()): List<LabInfo>

    suspend fun postBooking(bookingInfo: BookingInfo): Boolean
}