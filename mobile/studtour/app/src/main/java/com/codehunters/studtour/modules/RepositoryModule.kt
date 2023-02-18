package com.codehunters.studtour.modules

import com.codehunters.locale_store.data_store.IDataStoreService
import com.codehunters.network.services.IAuthService
import com.codehunters.network.services.IStudTourService
import com.codehunters.repository.auth.AuthRepository
import com.codehunters.repository.auth.IAuthRepository
import com.codehunters.repository.data_store.DataStoreRepository
import com.codehunters.repository.data_store.IDataStoreRepository
import com.codehunters.repository.stud_tour.IStudTourRepository
import com.codehunters.repository.stud_tour.StudTourRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideStudTourRepository(studTourService: IStudTourService): IStudTourRepository =
        StudTourRepository(studTourService)

    @Provides
    @Singleton
    fun provideAuthRepository(authService: IAuthService): IAuthRepository =
        AuthRepository(authService)

    @Provides
    @Singleton
    fun provideDataStoreRepository(dataStoreService: IDataStoreService): IDataStoreRepository =
        DataStoreRepository(dataStoreService)
}