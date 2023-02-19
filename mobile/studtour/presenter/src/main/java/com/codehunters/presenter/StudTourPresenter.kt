package com.codehunters.presenter

import com.codehunters.data.*
import com.codehunters.presenter.interfaces.IStudTourPresenter
import com.codehunters.repository.stud_tour.IStudTourRepository

class StudTourPresenter(
    private val studTourRepository: IStudTourRepository
): IStudTourPresenter {

    override suspend fun getArticles(): List<ArticleInfo> {
        return studTourRepository.getArticles()
    }
    override suspend fun getUniversities(universityID: String): List<UniversityInfo> {
        return studTourRepository.getUniversities(universityID)
    }
    override suspend fun getDormitories(dormitoryID: String): List<DormitoryInfo> {
        return studTourRepository.getDormitories(dormitoryID)
    }
    override suspend fun getRooms(roomID: String): List<RoomInfo> {
        return studTourRepository.getRooms(roomID)
    }
    override suspend fun getEvents(eventID: String): List<EventInfo> {
        return studTourRepository.getEvents(eventID)
    }
    override suspend fun getLabs(labID: String): List<LabInfo> {
        return studTourRepository.getLabs(labID)
    }

    override suspend fun postBooking(bookingInfo: BookingInfo): Boolean {
        return studTourRepository.postBooking(bookingInfo)
    }
}