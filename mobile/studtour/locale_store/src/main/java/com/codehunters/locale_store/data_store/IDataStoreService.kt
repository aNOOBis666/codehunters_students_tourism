package com.codehunters.locale_store.data_store

import kotlinx.coroutines.flow.Flow

interface IDataStoreService {
    suspend fun setAuthToken(token: String)
    val getAuthToken: Flow<String>
}