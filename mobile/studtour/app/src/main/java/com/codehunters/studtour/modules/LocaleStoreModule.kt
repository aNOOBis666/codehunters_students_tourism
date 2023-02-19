package com.codehunters.studtour.modules

import android.content.Context
import androidx.room.Room
import com.codehunters.locale_store.booking.BookingDatabase
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

    @Singleton
    @Provides
    fun provideReminderDatabase(@ApplicationContext context: Context): BookingDatabase =
        Room
            .databaseBuilder(
                context,
                BookingDatabase::class.java,
                "database"
            )
            .build()
}