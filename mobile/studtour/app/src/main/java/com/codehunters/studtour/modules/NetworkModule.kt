package com.codehunters.studtour.modules

import com.codehunters.network.services.AuthService
import com.codehunters.network.services.IAuthService
import com.codehunters.network.services.IStudTourService
import com.codehunters.network.services.StudTourService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    companion object {
        private const val TIMEOUT_IN_SECONDS = 30L
        private const val MEDIA_TYPE_JSON_DEFAULT = "application/json"
    }

    private val baseUrl: String = "https://codehunters-service.onrender.com/"
    private val bookingUrl: String = "https://stud-api.sabir.pro/"

    private val converterFactory = Json {
        isLenient = true
        ignoreUnknownKeys = true
        allowSpecialFloatingPointValues = true
        useArrayPolymorphism = true
        encodeDefaults = true
    }.asConverterFactory(MEDIA_TYPE_JSON_DEFAULT.toMediaType())

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .readTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        .connectTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)

    @Provides
    @Singleton
    fun provideStudTourService(): IStudTourService = StudTourService(baseUrl, bookingUrl, okHttpClient, converterFactory)

    @Provides
    @Singleton
    fun provideAuthService(): IAuthService = AuthService(baseUrl, okHttpClient, converterFactory)
}