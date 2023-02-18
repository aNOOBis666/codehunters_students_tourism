package com.codehunters.network.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseUniversityData(
//  Common ids
    @SerialName("id")
    val id: String? = null,
    @SerialName("userId")
    val userId: String? = null,
    @SerialName("universityId")
    val universityId: String? = null,
    @SerialName("dormitoryId")
    val dormitoryId: String? = null,
    @SerialName("eventId")
    val eventId: String? = null,

    @SerialName("content")
    val content: String? = null,
    @SerialName("cover")
    val posterUrl: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("createdTimestamp")
    val createdTimestamp: Long? = null,
    @SerialName("updatedTimestamp")
    val updatedTimestamp: Long? = null,
    @SerialName("tags")
    val tags: List<String>? = null,
    @SerialName("timestamp")
    val timestamp: Long? = null,

    @SerialName("name")
    val name: String? = null,
    @SerialName("position")
    val position: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("details")
    val details: ResponseUniversityData? = null,
    @SerialName("isDebug")
    val isDebug: Boolean? = null,
    @SerialName("onModeration")
    val onModeration: Boolean? = null,

    @SerialName("photo")
    val photoUrl: String? = null,
    @SerialName("site")
    val site: String? = null,
    @SerialName("committee")
    val committee: String? = null,
    @SerialName("region")
    val region: String? = null,
    @SerialName("shortName")
    val shortName: String? = null,
    @SerialName("district")
    val district: String? = null,
    @SerialName("adminContacts")
    val adminContacts: String? = null,
    @SerialName("city")
    val city: String? = null,
    @SerialName("address")
    val address: String? = null,
    @SerialName("founderName")
    val founderName: String? = null,
    @SerialName("establishmentYear")
    val establishmentYear: String? = null,
    @SerialName("contactsName")
    val contactsName: String? = null,
    @SerialName("shareholderName")
    val shareholderName: String? = null,
    @SerialName("street")
    val street: String? = null,
    @SerialName("houseNumber")
    val houseNumber: String? = null,
    @SerialName("coordinates")
    val coordinates: ResponseUniversityData? = null,
    @SerialName("minDays")
    val minDays: String? = null,
    @SerialName("maxDays")
    val maxDays: String? = null,
    @SerialName("photos")
    val photosUrls: List<String>? = null,
    @SerialName("main-info")
    val mainInfo: ResponseUniversityData? = null,
    @SerialName("rules")
    val rules: ResponseUniversityData? = null,
    @SerialName("isFree")
    val isFree: Boolean? = null,
    @SerialName("price")
    val price: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("amount")
    val amount: String? = null,
    @SerialName("dateRange")
    val dateRange: ResponseUniversityData? = null,
    @SerialName("dates")
    val dates: ResponseUniversityData? = null,
    @SerialName("owner")
    val owner: ResponseUniversityData? = null,
    @SerialName("unit")
    val unit: ResponseUniversityData? = null,
    @SerialName("admin")
    val admin: ResponseUniversityData? = null,
    @SerialName("from")
    val from: Long? = null,
    @SerialName("to")
    val to: Long? = null,
    @SerialName("isRegular")
    val isRegular: Boolean? = null,
    @SerialName("link")
    val link: String? = null,
    @SerialName("video")
    val video: List<String>? = null,
    @SerialName("WoS")
    val woS: String? = null,
    @SerialName("topic")
    val topic: String? = null,
    @SerialName("text")
    val text: String? = null,
    @SerialName("rating")
    val rating: Int? = null,
    @SerialName("published")
    val published: Boolean? = null,
    @SerialName("mealPlan")
    val mealPlan: String? = null,

    @SerialName("lat")
    val lat: Float? = null,
    @SerialName("lng")
    val lng: Float? = null,

    @SerialName("requiredUniDocuments")
    val requiredUniDocuments: String? = null,
    @SerialName("requiredStudentsDocuments")
    val requiredStudentsDocuments: String? = null,

    @SerialName("email")
    val email: String? = null,
    @SerialName("phone")
    val phone: String? = null,

    @SerialName("documents")
    val documents: List<String>? = null,
    @SerialName("services")
    val services: List<ResponseUniversityData>? = null,


    )

