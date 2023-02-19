package com.codehunters.repository.data_store

import com.codehunters.locale_store.data_store.IDataStoreService
import kotlinx.coroutines.flow.Flow

class DataStoreRepository(
    private val dataStoreService: IDataStoreService
) : IDataStoreRepository {
    override suspend fun setAuthToken(token: String) {
        dataStoreService.setAuthToken(token)
    }

    override val getAuthToken: Flow<String>
        get() = dataStoreService.getAuthToken
}