package com.codehunters.network.services

import com.codehunters.network.apiservice.StudTourApiService
import com.codehunters.network.data.requestStudTour.*
import com.codehunters.network.interceptors.AuthorizationInterceptor
import com.codehunters.network.mapping.*
import com.codehunters.network.requestStatus
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

class StudTourService(
    baseUrl: String,
    okHttp: OkHttpClient.Builder,
    converterFactory: Converter.Factory
) : IStudTourService {

    private val authInterceptor = AuthorizationInterceptor()

    private val client = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttp.apply { addInterceptor(authInterceptor) }.build())
        .addConverterFactory(converterFactory)
        .build()
        .create(StudTourApiService::class.java)

    override suspend fun setAuthToken(token: String) {
        authInterceptor.authToken = token
    }

    override suspend fun getArticles(): List<ArticleEntity> {
        return client.getArticles().requestStatus().toArticles()
    }

    override suspend fun getUniversities(universityID: String): List<UniversityEntity> {
        return client.getUniversities(universityID).requestStatus().toUniversities()
    }

    override suspend fun getDormitories(dormitoryID: String): List<DormitoryEntity> {
        return client.getDormitories(dormitoryID).requestStatus().toDormitories()
    }

    override suspend fun getRooms(roomID: String): List<RoomEntity> {
        return client.getRooms(roomID).requestStatus().toRooms()
    }

    override suspend fun getEvents(eventID: String): List<EventEntity> {
        return client.getEvents(eventID).requestStatus().toEvents()
    }

    override suspend fun getLabs(labID: String): List<LabEntity> {
        return client.getLabs(labID).requestStatus().toLabs()
    }

    override suspend fun getReviews(): List<ReviewEntity> {
        return client.getReviews().requestStatus().toReviews()
    }
}