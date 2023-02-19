package com.codehunters.network.apiservice

import com.codehunters.network.data.requestBooking.BookingData
import com.codehunters.network.data.response.ResponseData
import com.codehunters.network.data.response.ResponseLabsData
import com.codehunters.network.data.response.ResponseUniversityData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface StudTourApiService {

//  Receive News
    @GET("news")
    suspend fun getArticles(): Response<List<ResponseData>>

//  Receive Universities
    @GET("university/{universityID}")
    suspend fun getUniversities(
    @Path("universityID") universityID: String
    ): Response<List<ResponseUniversityData>>

//  Receive Dormitories
    @GET("dormitory/{dormitoryID}")
    suspend fun getDormitories(
    @Path("dormitoryID") dormitoryID: String
    ): Response<List<ResponseData>>

//  Receive Rooms
    @GET("room/{roomID}")
    suspend fun getRooms(
    @Path("roomID") roomID: String
    ): Response<List<ResponseData>>

//  Receive Events
    @GET("universityEvent/{eventID}")
    suspend fun getEvents(
    @Path("eventID") eventID: String
    ): Response<List<ResponseData>>

//  Receive Labs
    @GET("lab/{labID}")
    suspend fun getLabs(
    @Path("labID") labID: String
    ): Response<List<ResponseLabsData>>

    @POST("bookings")
    suspend fun postBooking(
        @Body bookingData: BookingData
    ): Response<List<ResponseLabsData>>
}