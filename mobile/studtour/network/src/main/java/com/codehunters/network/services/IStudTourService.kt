package com.codehunters.network.services

import com.codehunters.network.data.requestBooking.BookingData
import com.codehunters.network.data.requestStudTour.*

interface IStudTourService {
    suspend fun setAuthToken(token: String)

    suspend fun getArticles(): List<ArticleEntity>
    suspend fun getUniversities(universityID: String): List<UniversityEntity>
    suspend fun getDormitories(dormitoryID: String): List<DormitoryEntity>
    suspend fun getRooms(roomID: String): List<RoomEntity>
    suspend fun getEvents(eventID: String): List<EventEntity>
    suspend fun getLabs(labID: String): List<LabEntity>

    suspend fun postBooking(bookingData: BookingData): Boolean
}