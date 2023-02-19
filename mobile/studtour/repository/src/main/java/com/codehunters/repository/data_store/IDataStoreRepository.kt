package com.codehunters.repository.data_store

import kotlinx.coroutines.flow.Flow

interface IDataStoreRepository {
    suspend fun setAuthToken(token: String)
    val getAuthToken: Flow<String>
}