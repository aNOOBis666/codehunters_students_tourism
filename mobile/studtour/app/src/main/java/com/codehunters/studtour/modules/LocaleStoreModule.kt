package com.codehunters.studtour.modules

import android.content.Context
import com.codehunters.locale_store.data_store.DataStoreService
import com.codehunters.locale_store.data_store.IDataStoreService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocaleStoreModule {

    @Provides
    @Singleton
    fun provideDataStoreService(
        @ApplicationContext context: Context
    ): IDataStoreService = DataStoreService(context)
}