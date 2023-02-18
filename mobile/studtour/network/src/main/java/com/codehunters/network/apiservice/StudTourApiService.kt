package com.codehunters.network.apiservice

import com.codehunters.network.data.response.ResponseData
import com.codehunters.network.data.response.ResponseLabsData
import com.codehunters.network.data.response.ResponseUniversityData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StudTourApiService {

//  Receive News
    @GET("articles")
    suspend fun getArticles(): Response<List<ResponseData>>

//  Receive Universities
    @GET("universities/{universityID}")
    suspend fun getUniversities(
    @Path("universityID") universityID: String
    ): Response<List<ResponseUniversityData>>

//  Receive Dormitories
    @GET("dormitories/{dormitoryID}")
    suspend fun getDormitories(
    @Path("dormitoryID") dormitoryID: String
    ): Response<List<ResponseData>>

//  Receive Rooms
    @GET("rooms/{roomID}")
    suspend fun getRooms(
    @Path("roomID") roomID: String
    ): Response<List<ResponseData>>

//  Receive Events
    @GET("events/{eventID}")
    suspend fun getEvents(
    @Path("eventID") eventID: String
    ): Response<List<ResponseData>>

//  Receive Labs
    @GET("labs/{labID}")
    suspend fun getLabs(
    @Path("labID") labID: String
    ): Response<List<ResponseLabsData>>

//  Receive Reviews
    @GET("reviews")
    suspend fun getReviews(): Response<List<ResponseData>>
}